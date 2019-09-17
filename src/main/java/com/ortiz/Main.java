package com.ortiz;

import com.github.javafaker.Faker;
import com.ortiz.model.Person;
import com.ortiz.velocity.DateTimeTool;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.ToolManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {


    public static void main(String[] args) throws Exception {

        Faker faker = new Faker(new Locale("pt", "BR"));
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            final Person person = new Person();
            person.setName(faker.name().fullName());
            person.setDocumentNumber(Long.parseLong(faker.number().digits(10)));
            person.setBirthDate(LocalDate.of(faker.number().numberBetween(1970, 2010), 1, 1));
            person.setInsertDate(LocalDateTime.now());
            people.add(person);
        }
        render(people);
    }

    private static void render(List<Person> people) throws Exception {
        ToolManager manager = new ToolManager(true, true);
        Context context = manager.createContext();

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Template t = velocityEngine.getTemplate("template-insert.vm");

        context.put("people", people);
        context.put("datetime", new DateTimeTool());

        StringWriter writer = new StringWriter();
        t.merge(context, writer);

        try (FileOutputStream fileInputStream = new FileOutputStream(new File("inserts.sql"))) {
            fileInputStream.write(writer.toString().getBytes(StandardCharsets.UTF_8.name()));
        }
    }
}
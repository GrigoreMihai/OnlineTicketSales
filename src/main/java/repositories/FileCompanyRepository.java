package repositories;

import exceptions.InexistentFileExeception;
import models.Company;
import models.Event;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class FileCompanyRepository implements CompanyRepository {
    private final String file = "COMPANIES.csv";
    private final File EventsFile = new File("COMPANIES.csv");
    @Override
    public void add(Company company) {
        try{
            if(!EventsFile.exists()){
                System.out.println("Made new file");
                EventsFile.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(EventsFile, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(company.getId()+"," + company.getName()+","+ company.getCui() + ","+ company.getCard().toString() +"\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Company> findCompanyByCompanyname(String name) {
        Path path = Paths.get(file);
        Company c = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentFileExeception();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(",");
                if (attr[1].equals(name)) {
                    c = new Company();
                    c.setId(parseInt(attr[0]));
                    c.setName(attr[1]);
                    c.setCui(attr[2]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(c);
    }
    @Override
    public Optional<List<Company>> listAll() {
        Path path = Paths.get(file);
        List<Company> companies = new ArrayList<>();


        try {
            if (!Files.exists(path)) {
                throw new InexistentFileExeception();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String [] attr = u.split(",");
                Company c = new Company();
                c.setId(parseInt(attr[0]));
                c.setName(attr[1]);
                c.setCui(attr[2]);
                companies.add(c);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(companies);
    }
}


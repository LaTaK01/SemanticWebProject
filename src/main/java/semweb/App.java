package semweb;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
//import org.apache.jena.rdf.model.Property;
//import org.apache.jena.rdf.model.RDFNode;
//import org.apache.jena.rdf.model.Resource;
//import org.apache.jena.rdf.model.Statement;
//import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
//import org.apache.jena.riot.Lang;
//import org.apache.jena.riot.RDFDataMgr;
//import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.VCARD;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class App 
{
    public static void main( String[] args ) throws IOException
    {



        String url = "https://territoire.emse.fr/kg/";
        JsoupGet(url);


        /*String url2 = "https://www.w3.org/ns/sosa/";
        Model model = ModelFactory.createDefaultModel();
                    model.read(url2);
                    String datasetURL = "http://localhost:3030/ds";
                    String sparqlEndpoint = datasetURL + "/sparql";
                    String sparqlUpdate = datasetURL + "/update";
                    String graphStore = datasetURL + "/data";
                    RDFConnection conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);
                    conneg.load(model); // add the content of model to the triplestore
                    conneg.update("INSERT DATA { <test> a <TestClass> }"); // add the triple to the triplestore
*/

/*
        url2 = "https://w3c-lbd-cg.github.io/bot/bot.ttl";
        model = ModelFactory.createDefaultModel();
            model.read(url2);
            datasetURL = "http://localhost:3030/ds";
            sparqlEndpoint = datasetURL + "/sparql";
            sparqlUpdate = datasetURL + "/update";
            graphStore = datasetURL + "/data";
            conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);
            conneg.load(model); // add the content of model to the triplestore
            conneg.update("INSERT DATA { <test> a <TestClass> }"); // add the triple to the triplestore

*/
            /*
            url2 = "https://doc.realestatecore.io/3.3/asset.rdf";
            model = ModelFactory.createDefaultModel();
                model.read(url2);
                datasetURL = "http://localhost:3030/ds";
                sparqlEndpoint = datasetURL + "/sparql";
                sparqlUpdate = datasetURL + "/update";
                graphStore = datasetURL + "/data";
                conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);
                conneg.load(model); // add the content of model to the triplestore
                conneg.update("INSERT DATA { <test> a <TestClass> }"); // add the triple to the triplestore
*/


            CSVReader reader = new CSVReader(new FileReader("20211116-daily-sensor-measures.csv"), ',' , '"' , 1);
                
            //Read CSV line by line and use the string array as you want
            String[] nextLine;
            String urldebut="https://territoire.emse.fr/kg/emse/fayol/";
            Model modelSalle = ModelFactory.createDefaultModel();
            Model modelTemperature = ModelFactory.createDefaultModel();
            String urlFinal;
            String datasetURL = "http://localhost:3030/ds8";
            String sparqlEndpoint = datasetURL + "/sparql";
            String sparqlUpdate = datasetURL + "/update";
            String graphStore = datasetURL + "/data";

            RDFConnection conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);
            Property name;
            String localName = "";
            StringWriter test = new StringWriter();
                        String test2;
                        PrintWriter out = null;
                        
                        Writer output = null;
                        Float essai;
                        String[] arr;
                        FileWriter fw = null;
                        modelSalle = ModelFactory.createDefaultModel();
            modelTemperature = ModelFactory.createDefaultModel();
            int i=0;
            while ((nextLine = reader.readNext()) != null) {
            
            
            if (nextLine != null) {
                //Verifying the read data here
                if(!nextLine[7].isEmpty()){

                    arr = nextLine[9].split("/"); 

                        essai = Float.parseFloat(nextLine[7]);
                        if(arr.length>3){
                            i=i+1;
                            

                           modelSalle.createResource(urldebut+arr[2].substring(1)+"ET"+"/"+arr[3].substring(1)).addProperty(ResourceFactory.createProperty(urldebut+arr[2].substring(1)+"ET"+"/"+arr[3].substring(1)+"/temperature/"+i),ResourceFactory.createTypedLiteral(new Float(nextLine[7])))
                           .addProperty(ResourceFactory.createProperty(urldebut+arr[2].substring(1)+"ET"+"/"+arr[3].substring(1)+"/date/"+i), ResourceFactory.createTypedLiteral(new Float(nextLine[1])));


                        }

                }
                

            }
            }/*
            RDFDataMgr.write(test, modelSalle, Lang.NT);
                        //System.out.println(modelSalle);
                        
                        try {
                            File file = new File("test.nt");
                            fw=new FileWriter(file);
                            output = new BufferedWriter(fw);  //clears file every time
                            out = new PrintWriter(output);
                            System.out.println(test.toString());
                            out.println(test.toString());
                            //output.append(test.toString());
                            output.close();
                            out.close();
                            
                            //FileWriter fileWriter = new FileWriter(file);
                            //fileWriter.write(test.toString());
                            //fileWriter.flush();
                            //fileWriter.close();

                        } catch (IOException e) {
                           
                            e.printStackTrace();
                        }



                        finally {
                            if(out != null)
                                out.close();
                            try {
                                if(output != null)
                                    output.close();
                            } catch (IOException e) {
                                //exception handling left as an exercise for the reader
                            }
                            try {
                                if(fw != null)
                                    fw.close();
                            } catch (IOException e) {
                                //exception handling left as an exercise for the reader
                            }
                        }*/



                        /*coomenter ou decommenter selon si on veux charger notre nt*/
                        //Model model = ModelFactory.createDefaultModel();
                        //model.read("C:/Users/Users.DESKTOP-SOJULLM/Documents/M2-DSC/sem_web/SemanticWebProject/test.nt");
                        //System.out.println(model.toString());

                        conneg.load(modelSalle); // add the content of model to the triplestore

                        conneg.update("INSERT DATA { <test> a <TestClass> }"); // add the triple to the triplestore

        System.out.println( "Hello World!" );
    }
    
    public static void JsoupGet(String url) throws IOException{
        


        Document document = Jsoup.connect(url).get();
        Elements links = document.select("a[href]");
        
        for (Element link : links) {

                if(link.text().contains(".nt")){
                    Model model = ModelFactory.createDefaultModel();
                    model.read(url+link.text());
                    String datasetURL = "http://localhost:3030/ds8";
                    String sparqlEndpoint = datasetURL + "/sparql";
                    String sparqlUpdate = datasetURL + "/update";
                    String graphStore = datasetURL + "/data";
                    RDFConnection conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);
                    conneg.load(model); // add the content of model to the triplestore
                    conneg.update("INSERT DATA { <test> a <TestClass> }"); // add the triple to the triplestore
                }
        }
        for (Element link : links) {
            if(link.text().contains("/")){
                String url2 = url+link.text();
                JsoupGet(url2);
            }
        }
    }
}

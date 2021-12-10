package semweb;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
//import org.apache.jena.rdf.model.Property;
//import org.apache.jena.rdf.model.RDFNode;
//import org.apache.jena.rdf.model.Resource;
//import org.apache.jena.rdf.model.Statement;
//import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
//import org.apache.jena.riot.Lang;
//import org.apache.jena.riot.RDFDataMgr;
//import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.tdb.TDBFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Model model = ModelFactory.createDefaultModel();
        // ... build the model
        /*
        String url = "https://territoire.emse.fr/kg/ontology.nt";
        RDFConnection conneg = RDFConnectionFactory.connect(url);
        Model model = conneg.fetch("http://localhost:3030/ds");
        model.read(url);
        conneg.load(model);
        conneg.put(model);

*/
        String url = "https://territoire.emse.fr/kg/ontology.nt";
        Model model = ModelFactory.createDefaultModel();
        model.read(url);
// ... build the model
        String datasetURL = "http://localhost:3030/ds";
        String sparqlEndpoint = datasetURL + "/sparql";
        String sparqlUpdate = datasetURL + "/update";
        String graphStore = datasetURL + "/data";
        RDFConnection conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);
        conneg.load(model); // add the content of model to the triplestore
        conneg.update("INSERT DATA { <test> a <TestClass> }"); // add the triple to the triplestore
        

        System.out.println( "Hello World!" );
    }
}

package babelnet;

import static java.lang.System.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import it.uniroma1.lcl.babelnet.BabelNet;
import it.uniroma1.lcl.babelnet.BabelNetQuery;
import it.uniroma1.lcl.babelnet.BabelSense;
import it.uniroma1.lcl.babelnet.BabelSynset;
import it.uniroma1.lcl.babelnet.BabelSynsetID;
import it.uniroma1.lcl.babelnet.WordNetSynsetID;
import it.uniroma1.lcl.jlt.util.Language;
import it.uniroma1.lcl.jlt.wordnet.WordNetVersion;

public class HttpApi {

	public boolean getSynsetIds(File file, String lemma, String searchLang, String pos, String PORT) {
		BabelNet bn = BabelNet.getInstance();
		Language sLang = Language.EN;
		if(searchLang != null) {
			if(searchLang.equals("IT")) {
				sLang = Language.IT;
			}
		}

		BabelNetQuery query = new BabelNetQuery.Builder(lemma).from(sLang).build();
		List<BabelSynset> synsets = bn.getSynsets(query);

		List<SynsetId> SynsetIds = new ArrayList<SynsetId>();
		for (BabelSynset synset : synsets) {
			SynsetId synsetid = new SynsetId();
			synsetid.id = synset.getID().getID();
			synsetid.pos = synset.getPOS().toString();
			synsetid.source = synset.getSenseSources().toString();
			if(pos != null && synsetid.pos == pos) {
				SynsetIds.add(synsetid);
			}
			else if(pos == null){
				SynsetIds.add(synsetid);
			}
		}

		//File file = new File("files/"+PORT+"/getSynsetIds");
		try{
			//file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			try {
				bw.write(new Gson().toJson(SynsetIds));
		        bw.close();
			}catch(IOException e){
			    System.out.println(e);
			}
			finally {
				bw.close();
			}
		}catch(IOException e){
		    System.out.println(e);
		}
		return true;
	}

	public boolean getSynset(File file, String synsetid, String targetLang, String PORT) {
		BabelNet bn = BabelNet.getInstance();
		Language tLang = Language.EN;
		if(targetLang != null) {
			if(targetLang.equals("IT")) {
				tLang = Language.IT;
			}
		}

		BabelSynset babel_synset = bn.getSynset(new BabelSynsetID(synsetid));
		Synset synset = new Synset();
		synset.senses = babel_synset.getSenses(tLang);
		synset.wnOffsets = babel_synset.getWordNetOffsets();
		synset.mainSense = babel_synset.getMainSense(tLang).get().getFullLemma();
		synset.glosses = babel_synset.getGlosses(tLang);
		synset.examples = babel_synset.getExamples(tLang);
		synset.images = babel_synset.getImages();
		synset.synsetType = babel_synset.getSynsetType();
		synset.categories = babel_synset.getCategories(tLang);
		synset.translations = babel_synset.getTranslations();
		synset.domains = babel_synset.getDomains();
		synset.lnToCompound = babel_synset.getCompounds(tLang);
		synset.lnToOtherForm = babel_synset.getOtherForms(tLang);
		//synset.filterLangs = ;
		//synset.bkeyConcepts =;

		//File file = new File("files/"+PORT+"/getSynset");
		try{
			//file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			try {
				bw.write(new Gson().toJson(synset));
		        bw.close();
			}catch(IOException e){
			    System.out.println(e);
			}
			finally {
				bw.close();
			}
		}catch(IOException e){
		    System.out.println(e);
		}
		return true;
	}

	public boolean getSenses(File file, String lemma, String searchLang, String PORT) {
		BabelNet bn = BabelNet.getInstance();
		Language sLang = Language.EN;
		if(searchLang != null) {
			if(searchLang.equals("IT")) {
				sLang = Language.IT;
			}
		}

		BabelNetQuery query = new BabelNetQuery.Builder(lemma).from(sLang).build();
		List<BabelSynset> synsets = bn.getSynsets(query);
		List<BabelSense> Senses = new ArrayList<BabelSense>();
		for (BabelSynset synset : synsets) {
			for(BabelSense sense: synset.getSenses(sLang)) {
				Senses.add(sense);
			}
		}

		//File file = new File("files/"+PORT+"/getSenses");
		try{
			//file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			try {
				bw.write(new Gson().toJson(Senses));
		        bw.close();
			}catch(IOException e){
			    System.out.println(e);
			}
			finally {
				bw.close();
			}
		}catch(IOException e){
		    System.out.println(e);
		}
		return true;
	}

	public boolean getOutgoingEdges(File file, String synsetid, String PORT) {
		BabelNet bn = BabelNet.getInstance();
		BabelSynset babel_synset = bn.getSynset(new BabelSynsetID(synsetid));


		//File file = new File("files/"+PORT+"/getOutgoingEdges");
		try{
			//file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			try {
				bw.write(new Gson().toJson(babel_synset.getOutgoingEdges()));
		        bw.close();
			}catch(IOException e){
			    System.out.println(e);
			}
			finally {
				bw.close();
			}
		}catch(IOException e){
		    System.out.println(e);
		}
		return true;
	}

	public boolean getWordnetId(File file, String synsetid, String PORT) {
		BabelNet bn = BabelNet.getInstance();
		BabelSynset babel_synset = bn.getSynset(new BabelSynsetID(synsetid));

		List<WordNetSynsetID> wn_synsetids = new ArrayList<WordNetSynsetID>();
		for (WordNetSynsetID wn_synset : babel_synset.getWordNetOffsets()) {
			wn_synsetids.add(wn_synset);
		}

		//File file = new File("files/"+PORT+"/getWordnetId");
		try{
			//file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			try {
				bw.write(new Gson().toJson(wn_synsetids));
		        bw.close();
			}catch(IOException e){
			    System.out.println(e);
			}
			finally {
				bw.close();
			}
		}catch(IOException e){
		    System.out.println(e);
		}
		return true;
	}
	
	public boolean getBabelnetId(File file, String synsetid, String PORT) {
		BabelNet bn = BabelNet.getInstance();
		BabelSynset babel_synset = bn.getSynset(new WordNetSynsetID(synsetid, WordNetVersion.WN_30));
		
		List<BabelSynsetID> bn_synsetids = new ArrayList<BabelSynsetID>();
		try {
			bn_synsetids.add(babel_synset.getID());
		}
		catch(NullPointerException e) {
			System.out.println(e);
		}
		
		//File file = new File("files/"+PORT+"/getBabelnetId");
		try{
			
			//System.out.println(bn_synsetids);
			//file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			try {
				bw.write(new Gson().toJson(bn_synsetids));
		        bw.close();
			}catch(IOException e){
			    System.out.println(e);
			}
			finally {
				bw.close();
			}
		}catch(IOException e){
		    System.out.println(e);
		}
		return true;
	}

	public static void main(String[] args) {
		out.println("main");
	}

}

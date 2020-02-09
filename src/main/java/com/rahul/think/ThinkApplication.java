package com.rahul.think;

import com.rahul.think.entity.Movie;
import com.rahul.think.repository.MovieRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.server.PathContainer;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ThinkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ThinkApplication.class, args);
	}
	@Autowired
	MovieRepo movieRepo;
	Movie movie = new Movie();
	@Override
	public void run(String... args) throws Exception {
	Document movieListDoc=	Jsoup.connect("https://en.wikipedia.org/w/api.php?format=xml&action=query&list=embeddedin&einamespace=0&eilimit=50&eititle=Template:Infobox_film").get();
	Elements movieListElemnets = movieListDoc.select("api").select("query").select("embeddedin").select("ei");

	for (Element movie1:movieListElemnets){
		String movieUrl=movie1.attr("title");
		Movie movie = new Movie();
		movie.setTitle(movieUrl);
		Document htmldoc =Jsoup.connect("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=xml&page="+movieUrl).get();
//		//System.out.println(doc);
		Elements elements = htmldoc.select("api").select("parse").select("text");
//		System.out.println(e.toString());
		Document doc=Jsoup.parse(elements.text());
		Elements table=doc.select("table");
//
//
		for (Element row : table.select("tr")) {
//				System.out.println(row);
//			for (Element th:table.select("th")){
//				System.out.println(th);
//				System.out.println("val"+th.id());
//			}
			if(row.select("th").text().equals("Country")){
				//System.out.println(row.select("td").text());

			};
			if(row.select("th").text().equals("Directed by")){
				//System.out.println(row.select("td").text());
				movie.setDirector(row.select("td").text());
			};
			if(row.select("th").text().equals("Music by")){
				////System.out.println(row.select("td").text());
				movie.setMusicComposer(row.select("td").text());
			};
			if(row.select("th").text().equals("Production companies")){
				//System.out.println(row.select("td").text());
				movie.setProductionHouse(row.select("td").text());
			};
			if(row.select("th").text().equals("Produced by")){
				//System.out.println(row.select("td").text());
				movie.setProducer(row.select("td").text());
			};
			if(row.select("th").text().equals("Starring")){
				//System.out.println(row.select("td").text());
				movie.setActor(row.select("td").text());
			};
			if(row.select("th").text().equals("Production")){
				System.out.println(row.select("td").text());

			};
			if(row.select("th").text().equals("Release date")){
				//System.out.println(row.select("td").text());
				movie.setReleaseDate(row.select("td").text());
			};
			if(row.select("th").text().equals("Running time")){
				//System.out.println(row.select("td").text());
				movie.setDuration(row.select("td").text());
			};
			if(row.select("th").text().equals("Language")){
				//System.out.println(row.select("td").text());
				movie.setLanguage(row.select("td").text());
			};
			if(row.select("th").text().equals("Budget")){
				//System.out.println(row.select("td").text());
				movie.setBudget(row.select("td").text());
			};
			if(row.select("th").text().equals("Box office")){
				//System.out.println(row.select("td").text());
				movie.setBudgetOfficeCollection(row.select("td").text());
			};

		}
		movieRepo.save(movie);
	}



	}
}

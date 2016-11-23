package DreamDiary.services;

public class InterpreterService {
	
	private String[][] lykilord = { 
									{"kött", "ketti", "ógæfa muni hrella þig á næstunni."},
									{"dauð", "dauða", "einmannaleiki gæti verið að hrjá þig meir en en þú heldur."},
									{"þjóf", "þjófnað", "manni finnst maður ekki nógu öruggur"},
									{"fljú", "flug", "að það sé atburður í lífi einstaklings sem er að fara úr böndunum"},
									{"halda framhjá", "framhjáhald", "maki/unnussti sé ekki að eyða nægilegum tíma með þér að þínu mati."},
									{"flýg", "flug", "að það sé atburður í lífi einstaklings sem er að fara úr böndunum"},
									{"dett", "fall", "þú þurfir að létta á álagi í lífi þínu, oft tengt vinnu og/eða skóla."}, 
									{"fall", "fall", "þú þurfir að létta á álagi í lífi þínu, oft tengt vinnu og/eða skóla."},
									{"tenn", "tennur", "möguleiki sé á yfirvofandi dauðsföllum í fjölskyldunnni þinni."},
									{"naki", "nekt", "þú hafir líklegast miklar áhyggjur af yfirvofandi stöðuhækkun eða aukinnni ábyrgð."}, 
									{"próf", "próf", "Þú hefur áhyggur af skipulagi þínu og ættir að skipuleggja þig betur."}, 
									{"fræg", "hittingar við frægt fólk", "það gæti verið að hrjá þér að þér finnist þú ekki njóta nnnógu mikillar viðrkenningar."},
									{"elt", "vera eltur", "unndirmeðvitundinn að hvetja dreumanda til verks."},
									{"sein", "seinkun", "Heilinn sjé að vara mann við að taka ekki meir að sér en maður ræður við."},
									{"ost", "ost", "mikil hamingja mun finna þig á komandi árum."},
									{"ólétt", "ólétta", "þér finnst þú vera reiðubúinnn að taka á þig fleiri verkefni en þú hefur undanfarið."}
									
								  };
	private int numBadWords = 12;
	
	//current dream variables
	private int length = 0;
	private int lengthClass = 0;
	private int vowels = 0;
	private int[] keywords = new int[0];

	
	
	//	Notkun: interp = analyzeDream(drm);
	//	Fyrir:	interp er strengur og drm 
	//			er strengur sem inniheldur 
	//			drauminn sem á að ráða
	//	Eftir:	interp er strengur sem 
	//			inniheldur ráðninguna
	public String analyzeDream(String dream) {
		resetCurrentVars();
		gatherInfo(dream);
		if(length < 18) return "vinsamlegast skrifa lengri/ítarlegri lýsingu ef þú villt fá túlkun."
		dream = geraGreiningu();
		return dream;
	}
	
	//	Notkun: gatherInfo(drm);
	//	Fyrir:	drm er Strengur sem á að greina
	//	Eftir:	Búið er að vista upplýsingar í 
	//			Interpretorinum (þessum klasa)
	//			sem verða notaðar til greiningar 
	//			á draumnum
	private void gatherInfo(String dream) {
		length 			= dream.length();
		lengthClass 	= (int)Math.floor(this.length/35);
		vowels			= countVowels(dream);
		keywords		= fetchKeywords(dream);
	}

	//	Notkun: resetCurrentVars();
	//	Fyrir:	klasi er skilgreindur
	//	Eftir:	Klasi tilbúinn til að ráða nýjan draum
	private void resetCurrentVars() {
		this.length 		= 0;
		this.lengthClass 	= 0;
		this.vowels			= 0;
		this.keywords		= new int[0];
	}
	
	//	Notkun: i = countVowels(Str);
	//	Fyrir:	i er int og Str er strengur
	//	Eftir:	i jafngildir fjölda sérhljóða 
	//			í strengnum
	private int countVowels(String Str) {
		int lengd1 = Str.length();
		Str = Str.replace("a","");
		Str = Str.replace("á","");
		Str = Str.replace("e","");
		Str = Str.replace("é","");
		Str = Str.replace("i","");
		Str = Str.replace("í","");
		Str = Str.replace("u","");
		Str = Str.replace("ú","");
		Str = Str.replace("y","");
		Str = Str.replace("ý","");
		Str = Str.replace("æ","");
		Str = Str.replace("ö","");
		int lengd2 = Str.length();
		int svar = lengd1 - lengd2;
		return svar;
	}
	
	//	Notkun: str = fetchKeywords(Str);
	//	Fyrir:	klasi er skilgreindur
	//	Eftir:	Klasi tilbúinn til að ráða nýjan draum
	private int[] fetchKeywords( String Str) {
		Str = Str.replace(".","");
		Str = Str.replace(",","");
		Str = Str.replace("?","");
		Str = Str.replace("!","");
		Str = Str.replace("/"," ");
		Str = Str.replace("\"","");
		Str = Str.replace("\\","");
		String[] ord = Str.split(" ");
		int[] found = new int[0];
		for(int i = 0 ;  i < ord.length ; i++){
			for(int j = 0 ; j < this.lykilord.length ; j++){
				if(ord[i].contains(lykilord[j][0])){
					found = push(found, j );
				}
			}
		}

		return found;
	}
	
	//	Notkun: str = geraGreiningu();
	//	Fyrir:	Str er strengur og 
	//			Búið er að greina draum og skilgreina
	//			þær breytur sem notaðar eru til túlkunar
	//	Eftir:	str inniheldur túlkun á draum
	private String geraGreiningu() {
		//old stuff
		String greining = tulkaLengd();
		greining += interpKeywords();
		return greining;
	}
	
	private int calculateLokaVar(int V, int i) {
		int tempVar = 0;
		if(i < numBadWords) tempVar = 1;
		if(V == 4) V = tempVar;
		if(V == 1 && tempVar == 0) V = 2;
		if(V == 0 && tempVar == 1) V = 2;
		return V;
	}
	
	//	Notkun: str = interpKeywords();
	//	Fyrir:  Greining er hálfkláruð 
	//	Eftir:	str er miðpartur draumaráðningar 
	private String interpKeywords() {
		String temp = "";
		int lokaVar = 4; //is the interpretation posetive/negative or both? p=0, n=1, b=2.
		if(keywords.length == 0){
				//tóts send dream to database for interreting here:
				//tótZeFunction()
				temp += "Þessi draumur hefur þó ekki komið svona fyrir áður hjá okkur en hann hefur verið sendur nafnlaust til túlkunnar (tótz). ";
				temp += returnLokaOrd(2);
		} else {
			for(int i = 0; i < keywords.length; i++){
				if(i > 0) temp += returnGenericConecter();
				else 	  temp += (returnGenericStart() + "\n");
				temp += returnGenericStart2();
				temp += (lykilord[keywords[i]][1] + " ");
				temp += returnGenericStuff();
				temp += (lykilord[keywords[i]][2] + " ");
				//temp += returnGenericTimeStuff();
				lokaVar = calculateLokaVar(lokaVar, i);
			}
			if(lokaVar == 4) lokaVar = 0;
			temp += returnLokaOrd(lokaVar);
		}
		return temp;
	}
	
	private String tulkaLengd() {
		String tulkun;
		String[] case0 = {"Ef þú ert í erfiðleikum með að muna vel eftir draumunum þínum en mikilvægt skref til að laga það er að skrifa þá alltaf niður ítarlega og samviskusamlega. ", 
						  "Þó að þetta sé líklegast ekki þinn viðburðaríkasti draumur þá má lesa ákveðna hluti úr því sem þú manst. ",
						  "Torráðin lýsing, en þó fæst ákveðin ráðning úr þessum draumi. ",
						  "Hér er ekkert augljóst sem fæst túlkað úr þessum draumi, en hér er það sem við fáum greint. "
						 };
		String[] case1 = {"Einfaldir draumar eru oft bestu draumarnir en til ráðninga getur hvert smáatriði skipt máli. Úr þessari lýsingu má þó túlka töluvert. ", 
						  "Stuttar og góðar lýsingar geta skilað af sér töluverðu til greiningar en því ítarlegri því betra. Við fáum þó ýmislegt úr þessari lýsingu. ",
						  "Líklegast væri hægt að lesa úr þessum draumi meira ef að þú myndir fleiri smáatriði. Samt fæst úr því sem komið er margt."
						  };
		String[] case2 = {"Hér er dæmi um draum þar sem erfitt er að túlka nákvæmt hugarástand dreymandans en við fáum þó eithvað lesið úr þessu. ",
						  "Eflaust hefur þú sofið fast þessa nóttina en þetta er dæmi um draum sem skeður einungis á löngum REM-hringi dreymanda. ",
						  "Svona draumur er klassískt dæmi um einfalda ráðningu. ",
						  "Hugsanlegt er að þessi draumur stafi af óreglulegu svefnmynstri. Mælum við eindregið með föstum svefntíma (líka um helgar). ",
						  "Greinilegt er að þú hefur ekki hugsað nógu vel um svefn uppá síðkastið en torráðinn er þessi draumur ekki. "
						  };
		String[] case3 = {"Það gæti verið að draumur þessi stafi af óvenjulega djúpum svefn, en hér fæst margt ráðið. ",
						  "Vissulega áhugaverður draumur og við mælum eindregið með að taka fram ef hann skeður aftur á næstu vikum. ",
						  "Hér má lesa margt áhugavert úr þessum draumi. ",
						  "Góð ákvörðun að láta túlka þennan draum því að hér má margt lesa út. "
						  };
		String[] case4 = {
						  "Hér er að sjá hæfileika til að muna eftir mikilvægum hlutum úr draumum sínum. ",
						  "Greinilegt er að þú manst ansi margt úr þessum draum. ",
						  "Hér má sjá gott dæmi um eftirminnilegan draum. ",
						  "Hér er ýmislegt sem hægt er að greina frá en sumt mikilvægara en annað. ",
						  "Greinilegt er að hér er um að ræða ansi afdrifaríkan draum. "
						  };
		switch (lengthClass) {
            case 0:  tulkun = pickRand(case0);
                     break;
			case 1:  tulkun = pickRand(case1);
                     break;
            case 2:  tulkun = pickRand(case2);
                     break;
            case 3:  tulkun = pickRand(case3);
                     break;
            default: tulkun = pickRand(case4);
                     break;
        }
		return tulkun;
	}
	
	private String returnGenericStart() {
		String[] genericStarts = {"Við skynjum hér: ", "Greinilegt er að: ", "Hér margt ljóst: ",
								"Hérna sést að: ", "Frásögn þessi segir okkur að: ", "Hér er um að ræða að: ", "Hér fæst að: ",
								"Lesa má að: ", "Túlkanlegt er að: ", "Hér má sjá að: "};
		return pickRand(genericStarts);
	}
	
	
	private String returnGenericStart2() {
		String[] genericStarts = {"Þegar minnst er á ", "Oft þegar talað er um  ", "Stundum þegar fólk dreymir ",
									"Fyrirboðar einsog til dæmis ", "Þegar talað er um ", "Já, hér sjáum við "};
		return pickRand(genericStarts);
	}
	
	private String returnGenericConecter() {
		String[] genericStuff = {
			"En það er ekki allt og sumt. ", "Ráðningu líkur þó ekki hér. ", "Einnig viljum við benda á annað örlagavald í draumi þessum. ",
			"Ef aðeins þetta væri allt og sumt. ", "Frásögn þessi segir okkur þó ekki aðeins þetta. ", "En hér eru fleiri hlutir sem vert er nefna. "
		};
		return pickRand(genericStuff);
	}
	
	private String returnGenericStuff() {
		String[] genericStuff = {	
			"má búast við að ", "má gera ráð fyrir að ", "má túlka það þannig að ", "er hægt að búast við að "
		};
		return pickRand(genericStuff);
	}
	
	private String returnGenericTimeStuff() {
		String[] genericStuff = {	
			"á næstu dögum. ", "á næstunni. ", "í framtíð þinni. ", "á komandi dögum. "
		};
		return pickRand(genericStuff);
	}
	
	private String returnLokaOrd(int i) {
		String tulkun;
		String[] case0 = {
			"Þú hefur því ekkert að óttast og ættir því að halda áfram á sömu braut og eignast langt og gott líf.",
			"Þess vegna ættir þú ekki að hafa neinar áhyggjur af framtíðinni.",
			"Um að gera að njóta bara góðra tíma og halda áfram á sömu braut.",
			"Lífið er rússíbani, fáðu þér bara sæti og njóttu.",
			"Allt er því gott sem endar vel."
		};
		String[] case1 = {
			"Ekki hafa áhyggjur samt þar sem af illu leiðir gott.",
			"Stundum bítur maður í súra eplið, en það er áhætta sem þarf að taka til að finna hið sæta.",
			"Okkar ráð er að berðu höfuðið hátt og þá mun ekkert fá stoppað þig samt sem áður.",
			"Ekki bugast. Óbeygt stál er það brothættasta"
		};
		String[] case2 = {
			"Gott er að hafa í huga að lífið er ævintýri og á að taka sem slíku",
			"Munu bara ávallt: \" ekki styggja steggjina með loðnum leggjum heldur legðu þá hjá loðnum steggjum\"",
			"Niðurstaða: tilveran er sínus-bylgja",
			"Þegar margir áhrifavaldar eru í draumi þá ertu að gera eithvað rétt.",
			"Það er allir þorskar fiskar en ekki allir fiskar þorskar",
			"Stundum fellur eikin langt frá epplinu..."
		};
		switch (i) {
            case 0:  tulkun = pickRand(case0);
                     break;
			case 1:  tulkun = pickRand(case1);
                     break;
            case 2:  tulkun = pickRand(case2);
                     break;
            default: tulkun = "[generic lokaorð error]";
                     break;
        }
		return tulkun;
	}
	
	private String pickRand(String[] array) {
		int length = array.length;
		int picked = (int)Math.floor(Math.random()*length);
		return array[picked];
	}
	
	private int[] push(int[] array, int push) {
		int[] longer = new int[array.length + 1];
		System.arraycopy(array, 0, longer, 0, array.length);
		longer[array.length] = push;
		return longer;
	}
}

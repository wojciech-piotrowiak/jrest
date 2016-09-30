# Szkolenie Java REST Zadania

### Rozpoznanie środowiska pracy
1. Sklonowac repozytorium z projektem szkoleniowym ze wskazanego miejsca przez prowadzącego
1. Odpalic Eclipse/ Idee i zaimportować projekt rest-root (maven)
1. Skompilować cały projekt mvn clean install

### 01-plain-http-srv
 1. Kompilujemy i odpalamy jako aplikacje javy (`JavaRESTServer`).
 1. testujemy w przeglądarce uczymy sie konsoli "web developera" (`F12`)
 1. Zmianić program by reagował na scieżkę `/date` i zwracał klientowi dodatkowo aktualną datę serwera
 1. Dodać obsługę parametru (metody GET) o nazwie `format`, aby klient mogł okreslić jak ma wygladać odpowiedź.
    **Hint**:przyda się StringBuffer oraz metody split i contains z klasy String ;)

### 02-plain-http-clt
 1. Odpalamy klase klienta (`JavaRESTClient`) i testujemy serwis z poprzedniego zadania...
 1. Zmianić klase, tak aby metoda invoke przyjmowała parametr `format` daty i wywoływała zdalną usługę z odpowiednim parametrem.
 1. Napisać stronę html, która będzie wywoływać nasz serwis:
     1. za pomocą formularza i metody get bez parametrów url root serwisu (`localhost:81/`)
     1. za pomocą formularza i metody post bez parametrów url root serwisu
     1. za pomocą formularza i metody get `.../date`, z możliwością wpisania formatu daty
     1. za pomocą formularza i metody post `.../date`, z możliwością wpisania formatu daty

### 03-servlets
1. Podpinamy WildFly pod eclipse, albo Idee, ewentualnie używamy `mvn clean install wildfly:deploy`
1. Piszemy `CookieMonsterSerwlet`, który będzie zostawiał u klienta ciasteczko z datą odwiedziń.
    - przy pierwszych odwiedzinach wypisujemy `Welcome`,
    - przy następnych `Welcome again! Date and time of your last visit:` i data z odczytanego ciasteczka.
    
    Czy są jakieś problemy z odświeżaniem daty/godziny?
1. Piszemy Filtr który będzie dodawał do każdej odpowiedzi naszego ciasteczkowego serwletu kilka nagłówków:
    - "Cache-Control", "no-store, no-cache, must-revalidate"
    - "Cache-Control", "post-check=0, pre-check=0"
    - "Expires", "Fri, 12 Oct 2007 01:00:00 GMT"
    
    Czy pomogło? Dyskusja, jakie pułapki z metodami `setHeader` i `addHeader`
1. dodać obsługę stron/błędów 404 i 403 (`web.xml`)
1. dodać zabezpieczenie/zabronić wchodzenia na strony `*.html`
1. dla chętnych włączyć https dla naszego serwletu
1. dla chętnych, niech filtr sprawdza czy klient nie próboje wchodzić na strony `*.xhtml`,
    niech wtedy przekierowuje na strone główną...
1. napisać stronę html testującą nasz serwlet getem i postem. Odpalamy ja lokalnie z eclipsy ;)
   (Jak widac nie za dobra to jest przeglądarka)

### 04-jaxb
1. Wygenerować klasy javy na podstawie XSD `Booksote.xsd` - mavenem.
   Czy wyszły ładne klasy?
1. Wygenerować klasy javy na podstawie XSD `BookstoreBetter.xsd`.
   Czy wyszły ładniejsze? 
1. Napisać klasę `JaxBPars` która w funkcji main będzie:
   1. tworzyć obiekt Autor(Karol, Maj) i jakąś ksiązkę...
   1. tworzyć obiekt Magazyn(Pani Domu, itp)
   1. stworzy obiekt Bookstore i włoży do niego wczensiejsze obiekty
   1. dokona marszalingu obiektu Books i wyswietli wynik na konsoli.
   1. dokona marszalingu samego Magazynu i wyswietli wynik na konsoli
   1. dokona marszalingu samego Autora i wyswietli wynik na konsoli.
   1. dokona unmarszalingu pliku `Bookstore.xml` i wyswetli na konsole wynik `toString()` z
      otrzymanego obiektu.
   1. dokona unmarszalingu Autora (xml) przekazanego jako string i wyświetli wynik metody
      `toString()` na konsoli.
1. Napisać serwlet `XmlSerwlet`, który będzie odpowiadał na ządania klientów XML'em.
   Serwlet sobie wczytuje nasza baze `bookstore.xml` a potem serwuje klienom tylko liste
   magazynów. Opcjonalnie, obslużyć też wyszukiwanie po przekazanym parametrze.

### 05-jackson
1. Klasa Jacek
    1. Wczytać json "{\"type\":\"Book\", \"title\":\"Jacek i Placek\",\"isbn\":5}"; 
      i wypisac na sysout `toString()` obiektu wczytanego
    1. Stworzyć obiekt `Magazyn`, zapisac do string json i wyswietlic wynik na konsole.
    1. Wczytać `Boostore.json` i wypiasac na konsole wynik `toString()` na otrzymanym obiekcie. 
       (uwaga dziedziczenie)
    1. Zapisywać strumieniowo jsona tworzonego "ręcznie". (uwaga na close() strumienia).
1. Napisać klasę `BookStoreBase`, która będzie udawać bazę danych ;) 
    1. Bedzie ona przy inicjalizacji swojej wczytywać `Bokstore.json`.
    1. Funkacja `getItems()` będzie zwracać zawartość całej bazy.
    1. Funkcja `getMagazines()` będzie zwracać tylko listę magazynów.
    1. Funkcja `addMagazine()` będzie dodawać nowy Magazyn do bazy.
1. Napisać JSONServlet który:
    1. W metodzie `doGet()`, zwrac w postaci JSONa wszystkie dostępne Magazyny w Bookstorze
    1. W metodzie `doPost()` obsługujemy dodanie nowego Magazynu do Bookstora. POSTem wysyłamy JSON,
       w odpowiedzi może zwracać listę magazynów, albo status 200.
    1. Napisać stronę "statyczna" html 
        - pobierającą getem - listę Magazynów
        - wysyłającą postem z formularza dane nowego magazynu do dodania... 
          i wyswietlającą zwróconego jsona na stronie lub w okienku alert. 
          **Hint:**(JQuery bedzie najwygodniejsze, zapewne)
                   
### 06-jaxrs

1. Klasę `Echo` podpięć pod scieżkę _/say_  
1. Metodę `say(who)` podpiąć pod scieżkę GET i _/im/{who}_. Gdzie cześć urla _who_ będzie wstrzykiwana
   do parametru metody
1. Zadeplojować wara i potestować serwis wpisując ręcznie w url, a także ze strony _http://localhost:8080/06-jaxrs/index-echo.html_
   Potestować ostatni człon urla ze spacją ;) (_../say/cos i cos_ i _.../say/cos i cos/a tu cos_)
1. Metodę `say(who, howMany, agent)` podpiąć pod GET i tego samego urla co w punkcie 1.
   `howMany` powinien być wstrzykiwany z parametru zawartego w url o nazwie `count`.
   Parametr `agent` wypełniamy zawartością headera requestu `User-Agent`.
   Parametr `count` powinen miec domyślna wartość ustawianą na 1.
   - czy _polimorfizm REST_ zadziałał?
   - czy usuniecie domyslnej wartości parametru `count` cos zmienia?
   - Czy dodanie adnoacji `@Encoded` przed parametrem who coś zmienia w obsłudze spacji w url?
1. Metodę `echo(who, what)` podpiąć pod POST i scieżkę _/{who}_.
   Parametr `who` jest ustawiany z url, a parametr `what` jest pobierany z danych wyslanych z formularza (content posta).
1. Przerobić metody by zwracaly obiekt klasy `Response`.   
2. Piszemy CRUDA dla naszego Bookstore
      - BookstoreAPI (interfejs) ogolnie to produkuje jsona i mapowane jest pod /bookstore
      - getBooks() - /books
      - getMagazines() - /magazines i produkuje text/plain
      - getItems() - /items i produkuje xml (moze byc tez gzipowane i keszowane)
      - getBook(id) - /books/isbn
      - addBook(id, title) - /books/isbn?title=cos...
      - updateBook(id,title) - /books/isbna?title=cosinnego...
      - removeBook(id) - /books/isbn
2. Piszemy iplementacje BookstoreImp
2. W miedzy czasie sobie testujemy, co sie da... ;)

https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-JAX-RS-Project-Setup-1.5.X
### 07-      

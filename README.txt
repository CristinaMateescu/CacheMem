
	Clasa Subscriptie - clasa abstracta 
		
		Atribute : 
			nume 		- numele obiectului

			timestamp 	- un intreg cu valoarea data de un contor ce se actualizeaza la fiecare operatie "get"
					- se actualizeaza la accesarea elementului
					- cu cat are valoarea mai mare, cu atat elementul a fost accesat mai recent

			accesari 	- numarul de accesari al unui obiect
		
		Constructori:
			fara parametru 	- cu rol de initializare a atributelor 'timestamp' si 'accesari'
	
		Metode :
			setTimestamp		 	- actualizeaza timestamp-ul cu noua valoare data ca parametru
							- incrementeaza numarul de accesari
			
			getType 			- metoda abstracta, va fi implementata in subclase
							- va returna tipul subscriptiei

	
	Clasa Free - mosteneste clasa Subscriptie
		
		Atribute : doar cele mostenite 
		
		Constructor fara parametru
	
		Metode :
			
			getType 	- suprascrisa, returneaza un string ce reprezinta tipul Subscriptiei - "Free"


	Clasa Basic - mosteneste clasa Free
	
		Atribute : 
			Basic_contor	- un intreg ce reprezinta numarul de accesari de tip Basic
		
		Constructori:
			Fara parametru 	- rol de initializare a contorului Basic
	
			Cu parametru	- seteaza numele si Basic_contor cu valorile primite ca parametri

		Metode:
			
			getType 	- suprascrisa
					- daca nu au fost epuizate accesarile de tip Basic, se returneaza tipul "Basic"
					  altfel, se merge pe lantul de mosteniri si se apeleaza metoda superclasei (Free)

	Clasa Premium - mosteneste clasa Basic
		
		Atribute : 
			Premium_contor	- un intreg ce reprezinta numarul de accesari de tip Premium
		
		Constructori:
			Fara parametru - rol de initializare a contorului Premium
			
			Cu parametru   - seteaza numele, Basic_contor si Premium_contor cu valorile primite ca parametru
		
		Metode :
			
			getType 	- suprascrisa
					- daca nu au fost epuizate accesarile de tip Premium, se returneaza tipul "Premium"
					  altfel, se merge pe lantul de mosteniri, se apeleaza metoda superclasei (Basic)

		
	Clasa Memory - folosita pentru memoria principala
		
		Atribute : 
			un obiect 'memory' de tip ArrayList cu obiecte de tip Subscriptie
		
		Constructor fara parametru, rol de initializare
		
		Metode : 
			contine 	- de tip boolean
					- returneaza true daca memoria contine un element cu un nume dat
					- se parcurge memoria si se compara, folosind metoda "equals", cu numele primit ca parametru
		
			suprascrie	- metoda ce suprascrie un obiect in memorie
					- se cauta indexul la care se afla obiectul
					- se creeaza un nou obiect cu tipul corespunzator 
					- se seteaza noul obiect la indexul respectiv

			adauga		-adauga un obiect in memorie
		
			getElement	- returneaza un obiect de tip Subscriptie 
					- este cautat dupa nume in memorie
					- daca el nu exista, se returneaza null
	
	Interfata Cache
		
		Metode (ce vor fi implementate in tipurile de Cache) :
			
			add		- adauga un element in cache

			remove		- elimina din cache 

			contine 	- returneaza true/false in functie de existenta in cache

			dimensiune 	- returneaza numarul de elemente din cache

			elimina_element	- elimina din cache un element cu un nume dat

			getElement	- returneaza referinta la un obiect cu un nume dat

	Clasa FIFOCache ( implements Cache )

		Atribute : 
			cache 	- un ArrayList cu elemente de tip Subscriptie
		
		Constructor fara parametru cu rol de initializare

		Metode : 
			add 		- adauga un element in cache (la sfarsitul array-ului)

			remove 		- cache-ul este de tip FIFO 
					- eliminarea se face de la inceput :
					- se elimina elementul cu index-ul 0

			contine		- returneaza true daca obiectul exista in cache
					- se parcurge cache-ul, se cauta elementul dupa nume
					- se foloseste metoda "equals" pentru compararea numelui dat ca parametru cu numele obiectelor

			elimina_element	- elimina un obiect cu un nume dat
					- este parcus array-ul, se cauta obiectul cu numele dat, se retine indexul
					- se elimina elementul cu indexul respectiv

			dimensiune	- returneaza numarul de obiecte din cache

			getElement	- returneaza referinta la un obiect cu un nume dat
					- este parcurs cache-ul, se cauta elementul dupa nume ( folosind metoda equals)
					- daca nu exista, se returneaza null

	Clasa LRUCache ( implements Cache ) 

		Atribute : 
			cache 	- un ArrayList cu elemente de tip Subscriptie
		
		Constructor fara parametru cu rol de initializare

		Metode : 
			add 		- adauga un element in cache (la sfarsitul array-ului)

			remove 		- cache-ul este de tip LRU 
					- se elimina obiectul cu cel mai mic timestamp
					- este parcus cache-ul, se cauta elementul cu timpestamp minim
					- elementul corespunzator este eliminat

			contine		- returneaza true daca obiectul exista in cache
					- se parcurge cache-ul, se cauta elementul dupa nume
					- se foloseste metoda "equals" pentru compararea numelui dat ca parametru cu numele obiectelor

			elimina_element	- elimina un obiect cu un nume dat
					- este parcus array-ul, se cauta obiectul cu numele dat, se retine indexul
					- se elimina elementul cu indexul respectiv

			dimensiune	- returneaza numarul de obiecte din cache

			getElement	- returneaza referinta la un obiect cu un nume dat
					- este parcurs cache-ul, se cauta elementul dupa nume ( folosind metoda equals)
					- daca nu exista, se returneaza null	

	Clasa LFUCache ( implements Cache )
		
		Atribute : 
			cache 	- un ArrayList cu elemente de tip Subscriptie
		
		Constructor fara parametru cu rol de initializare

		Metode : 
			add 		- adauga un element in cache (la sfarsitul array-ului)

			remove 		- cache-ul este de tip LFU 
					- se elimina obiectul cu cel mai mic numar de accesari
					- se parcurge cache-ul, se cauta elementul cu cel mai mic numar de accesari
					- daca sunt mai multe, se elimina primul 
					- se reinitializeaza numarul de accesari

			contine		- returneaza true daca obiectul exista in cache
					- se parcurge cache-ul, se cauta elementul dupa nume
					- se foloseste metoda "equals" pentru compararea numelui dat ca parametru cu numele obiectelor

			elimina_element	- elimina un obiect cu un nume dat
					- este parcus array-ul, se cauta obiectul cu numele dat, se retine indexul
					- se elimina elementul cu indexul respectiv

			dimensiune	- returneaza numarul de obiecte din cache

			getElement	- returneaza referinta la un obiect cu un nume dat
					- este parcurs cache-ul, se cauta elementul dupa nume ( folosind metoda equals)
					- daca nu exista, se returneaza null	

	Clasa Main, metoda main :
			
		Se citesc datele;
		Variabile : 	capacity  - capacitatea cache-ului
				operation_nr - numar de operatii (add, get )

		Se creeaza si initializeaza :
				o memorie : memory 
				un cache  : cache   , cu tipul de cache corespunzator 
		
		Se initializeaza un contor - ce va da timestamp-ul, se incrementeaza la operatii de tip get

		Pentru fiecare operatie : 
			
			Se citeste operatia 
			Se identifica tipul: 
				Pentru operatii de tip ADD :
				  Se initializeaza cele doua contoare cu numarul de accesari din fiecare tip 
				  contor_basic = numar accesari tip basic
				  contor_premium = numar accesari tip premium
				  
				  Se cauta obiectul in memorie folosind metoda 'contine' 
				     In cazul in care exista deja : 
					 este suprascris obiectul 
					 - se cauta obiectul in cache, se elimina daca exista
				     In cazul in care nu exista : 
					 este instantiat un nou obiect Subscriptie cu tipul corespunzator 
					 este adaugat in memorie

				Pentru operatii de tip GET :
				  Este cautat obiectul in cache 
					Daca el exista, se actualieaza contorul
					Se seteaza timestamp-ul cu noua valoarea folosind metoda setTimestamp
					Se afiseaza 0 (exista in cache ) impreuna cu tipul Subscriptiei dat de metoda getType
				  Daca nu exista in cache, 
			 	  Este cautat in memoria principala 
					Pentru a fi adaugat si in cache, se verifica daca s-a ajuns la capacitatea maxima
					Se face eliminarea din cache, dupa tip, daca e necesar
					Se adauga elementul in cache 
					Se actualieaza contorul, timestampul
					Se afiseaza 1 (exista doar in memorie) impreuna cu tipul Subscriptiei dat de metoda getType
				  Daca nu exista nici in memoria principala
					Se afiseaza "2"
					

				  	 
		
		 	 


# TF-IDF with MapReduce

- Initial input: folder path with some documents
- Final output: list of (word, doc) ranked by ascending value of TF-IDF

The 4 MapReduce rounds are to be run successively.

The highest scores are at the trail of this output. 

Example of output for input_docs folder:
```
5.235250603583094E-4	(dave, callwild.txt)
5.671521487215018E-4	(around, callwild.txt)
5.889657130763361E-4	(solleks, callwild.txt)
6.107792370846943E-4	(traces, callwild.txt)
6.107792370846943E-4	(ice, callwild.txt)
6.342635086662482E-4	(thoughts, defoe-robinson-103.txt)
6.544063254478868E-4	(hal, callwild.txt)
6.544063254478868E-4	(team, callwild.txt)
8.071011548922984E-4	(perrault, callwild.txt)
8.72541767263849E-4	(john, callwild.txt)
8.943553316186832E-4	(trail, callwild.txt)
0.0010228213356125299	(friday, defoe-robinson-103.txt)
0.0010252365563617847	(bucks, callwild.txt)
0.0011343042974430036	(francois, callwild.txt)
0.0013088126508957736	(sled, callwild.txt)
0.0013088126508957736	(spitz, callwild.txt)
0.0016685130239661784	(myself, defoe-robinson-103.txt)
0.0017668970988825323	(thornton, callwild.txt)
0.0024431169483387772	(dogs, callwild.txt)
0.006827639187626952	(buck, callwild.txt)
```

## Pipeline
The classes in utils are the classes implementing the Writable interface. They are mandatory if we want to pass certain keys and values across mappers.


- *Round 1: (Raw text) -> list of ([word, docName], wordCount)*
  - Mapper: Raw text -> ([word, docName], 1)
  - Reducer: ([word, docName], [1, 1, ...]) -> ([word, docName], wordCount)
 
- *Round 2: ([word, docName], wordCount) -> ([word, docName], [wordCount, #wordsInDoc])*
  - Mapper: ([word, docName], wordCount) -> (docName, [word, wordCount])
  - Reducer: (docName, [[word1, wordCount1], [word2, wordCount2], ...]) -> ([word, docName], [wordCount, #wordsInDoc])
  
- *Round 3 : ([word, docName], [wordCount, #wordsInDoc]) -> ([word, docName], [wordCount, #wordsInDoc, #docsPerWord])*
  - Mapper: ([word, docName], [wordCount, #wordsInDoc]) -> (word, [doc, wc, wpd])
  - Reducer: (word, ([[doc1, wc1, wpd1], [doc2, wc2, wpd2], ...) -> ([word, docName], [wordCount, #wordsInDoc, #docsPerWord])

- *Round 4: ([word, docName], [wordCount, #wordsInDoc, #docsPerWord]) -> ([word, docName], tf-idf)* (only a mapper)

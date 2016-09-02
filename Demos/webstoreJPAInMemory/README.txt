
EMBEDDED H2 database example -- GOOD for UNIT[Spring DATA Repository objects]  & Integration testing
Embedded H2 DB acts as a "Fake" Test Double

"Substituted a SPRING Data Repository [interface] for the in-memory repository implementation
See: ProductRepository.java


LOAD products by running populateMySQL.sql script in src/main/sql
NOTE: gets cleared on EVERY reload of Application based on 
"create" property setting in applicationContext.xml

Unidirectional One to Many Customer - Product  With Join Column
access with products/cascade  UNDER ProductController
URL to invoke : /products/cascade

CAN SET UP:
bidirectional One to Many Customer - Product  REMOVE Join Column - defaults to JoinTable
uncomment customer in Product domain object
URL to invoke : /products/cascade



Can see the effects of local cache:
/products/cache

Can see the effects of JPQL with fetch by descending order
/products/fetch

Can exercise the  Criteria API
/products/fetchSpec




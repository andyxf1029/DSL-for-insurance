DSL-for-insurance
=================
#UI Data context fetch module

*User can  use field name(label name) or field Code  in rule file as a attribute , System will pass label name plus some additional conditions (insured id , coverage code , coverage Id ,interest code ,interest Id) to UI data context fetch module, UI data fetcher will find value in current UIDataContext  base on label name and additional info*

###Example 
####rule 
if(Each Occurrence Limit>100)

*if  rule assign to SPH, rule engine will pass coverage code `SPH` and label name `Each Occurrence Limit` to UI data context fetch module , fetch module find value binding logic  `coverType.fieldValueMap.US02EachOccurrenceLimit` and fetch value in current UIDataContext*



#Service Data Context Fetch module 
*User can use field name or field code in rule as a attribute , System will use Submission SOABO as context ,when rule is executed , rule engine will pass rule attribute ,additional information and context to  service Data context fetch module , this module will find mapping rule in field list definition module and return value base on current context *

#Trigger point interface 


	RuleResult tigger(Event event);



#Calculation data context Fetch module 
//TO-DO 


#Process for Rule engine 
ref to rule engine vsd

#DSL feature design 

**attribute** : `field name or field code`

**update field vaule** : `set("AttributeName",value)`

**condition** :

> if(condition){  
> 
> //Process A
> 
> }else{
> 
> //Process B 
> 
> }
> 


**call service**:`service.method(parameter ... )`

*eBao will provide service API  document*

####embed method

`avg(valueList ...)`

`sum(valuelist ...)`

`coverage(code) : find coverage in context `

**loop**:

> for(location in LocationArray){
> 		
> }

*Or*

`LocationArray.each{location -> print(location.no)}`


**find fisrt result in collection** : 

`LocationArray.find{location -> location.premium>2000}`

**find match results in collection** : 


`LocationArray.findAll{location -> location.premium>2000}`

#Rule maintain module 
//TO-DO ref to rule maintain document 


#Rule tracking system 
System have ability to tracking rule in real time base on event tracking information(username etc..)

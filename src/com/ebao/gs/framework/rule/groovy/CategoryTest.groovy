
@Category(Script)
class ClosureCategory {
	def getValue(String name ){
		println(name)
	}
	
	
}
def run(closure,context){
	use(ClosureCategory)
	{ closure.getValue("AA")}
}




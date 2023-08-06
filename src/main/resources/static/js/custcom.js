
var com = {
	tmpArray:[],
	onlyNumVal: function(getVal) {
		var retVal="";
		if(getVal==null || getVal==undefined) return "";
		for(var i=0; i < getVal.length;i++) {
			if(iisNaN(getVal.charAt(i))) {
				retVal+=getVal.charAt(i);
			}
		}
		return "";
	},
	arrayFilterCallback: function(e,self) {		
		for(var i=0; i < self.tmpArray.length;i++) {
			if(e==self.tmpArray[i]) {
				return true;
			}	
		}
		return false;
	},
	arrayCopy: function(getArray) {
		var self=this;
		if(getArray == undefined || getArray == null) return [];
		if(getArray.length == 0) return [];
		return JSON.parse(JSON.stringify(getArray));
	},
	isSameArray : function (getArray1,getArray2) {
		var self=this;		   
		
		if(getArray1 == null || getArray1 == undefined || getArray2 == null || getArray2 == undefined ) {
		   		return false;
		}
		console.log('getArray1==['+getArray1+']');
		console.log('getArray2==['+getArray2+']');
		var copyArray1=self.arrayCopy(getArray1);		   
		var copyArray2=self.arrayCopy(getArray2);	
		copyArray1.sort();
		copyArray2.sort();
		console.log('copyArray1==['+copyArray1+']');
		console.log('copyArray2==['+copyArray2+']');
		
		console.log('getArray1==['+getArray1+']');
		console.log('getArray2==['+getArray2+']');
		
		
		self.tmpArray=self.arrayCopy(getArray2);
		var comPareBaseArray1=getArray1.filter(function(ev) { return self.arrayFilterCallback(ev,self) });
		console.log('comPareBaseArray1==['+comPareBaseArray1+']');
		
		if(copyArray1.length !=copyArray2.length) return false;
		for(var i=0 ; i < copyArray1.length; i++) {
			if(copyArray1[i] != copyArray2[i]) {
				return false;
			}
		}
		return true;   
	}
}	
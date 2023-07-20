// import readline module
const readline = require("readline");

// create interface for input and output
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

// create empty user input
let userInput = "";

const readInput = ()=>{
//   const input = prompt();
	rl.question("Enter the Array seperated with ',' : ", function (string) {
		userInput = string;
		inputValidator(userInput);
// close input stream
		rl.close();
	});
}

const inputValidator = (input)=>{
  if(checkForConsecutive(input)){
     outputPrinter("Given numbers are Consecutive");
  }
  else{
    outputPrinter("Given numbers are not Consecutive");
  }
}

const checkForConsecutive = (input)=>{
  let array = input.split(",").map((element)=>parseInt(element)).sort((a,b)=>a-b);
  if((array.length - 1) + array[0] === array[array.length-1]){
    return true;
  }
  else{
    return false;
  }
}

const outputPrinter = (result)=>{
  console.log(result);
}

readInput();
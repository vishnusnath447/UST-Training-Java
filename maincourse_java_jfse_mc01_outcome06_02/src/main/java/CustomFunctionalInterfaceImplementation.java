public class CustomFunctionalInterfaceImplementation{
    MyFunction<String> myFunctionStr = (s)->{
        String result = "";
        if(s == null){
            return "Null String";
        }
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                result=result+Character.toLowerCase(s.charAt(i));
            }
            else if(Character.isLowerCase(s.charAt(i))){
                result=result+Character.toUpperCase(s.charAt(i));
            }
        }
        return result;
    };

    MyFunction<Integer> myFunctionInt = (i)->{
        if(i == null){
            return null;
        }
        return i*i*i;
    };

}
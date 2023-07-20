package in.stackroute.letterCombination;

import com.sun.jdi.request.ThreadStartRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> generateCombinations(String number){
        List<String> result = new ArrayList<>();
        Map<Character,String> keyPairs = new HashMap<>();
        keyPairs.put('2',"abc");
        keyPairs.put('3',"def");
        keyPairs.put('4',"ghi");
        keyPairs.put('5',"jkl");
        keyPairs.put('6',"mno");
        keyPairs.put('7',"pqrs");
        keyPairs.put('8',"tuv");
        keyPairs.put('9',"wxyz");
        if(number.isEmpty()){
            return result;
        }
        List<String> temp = new ArrayList<>();
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)>='2' && number.charAt(i)<='9'){
                for(Map.Entry<Character,String> element:keyPairs.entrySet()){
                    if(element.getKey().equals(number.charAt(i))){
                        temp.add(element.getValue());
                    }
                }
            }
        }
        if(temp.size()==1){
            for(int i=0;i<temp.get(0).length();i++){
                String s= "";
                s=s+temp.get(0).charAt(i);
                result.add(s);
            }
        }
        for(int k=0;k<temp.size()-1;k++){
            String firstS = temp.get(k);
            String secondS = temp.get(k+1);
            String s="";
            for(int i=0;i<firstS.length();i++){
                s="";
                for(int j=0;j<secondS.length();j++){
                    s=""+firstS.charAt(i)+secondS.charAt(j);
                    result.add(s);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.generateCombinations("2").toString());
        System.out.println(letterCombinations.generateCombinations("23").toString());
        System.out.println(letterCombinations.generateCombinations("234").toString());
    }
}


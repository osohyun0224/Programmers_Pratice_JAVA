class Solution {
  public String solution(String new_id) {
  String answer = "";
  String resultid = "";
   
  resultid = new_id.toLowerCase();
  System.out.println(resultid);
       
  
  resultid = resultid.replaceAll("[^a-z0-9-_.]", "");
  System.out.println(resultid);
   
  resultid = resultid.replaceAll("[.]{2,}", ".");
  System.out.println(resultid);
   

  resultid = resultid.replaceAll("^[.]|[.]$", "");
  System.out.println(resultid);
   
  if(resultid.equals("")) {
    resultid = "a";
  }
  System.out.println(resultid);
   

  if(resultid.length() > 15) {
    resultid = resultid.substring(0, 15);
    resultid = resultid.replaceAll("[.]$", "");
  }
  System.out.println(resultid);
   
  
  if(resultid.length() <= 2) {
    String lastStr = resultid.substring(resultid.length() -1);
    while(resultid.length() < 3) {
      resultid = resultid.concat(lastStr); 
    }	 
  }
  System.out.println(resultid);
      
  answer = resultid;
  return answer;
  }
}

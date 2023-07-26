import java.util.regex.Pattern;
import java.util.regex.Matcher;

 class userException extends Exception{
        public userException(){
            super();
        }

        public userException(String s){
            super(s);
        }
    }

     class Student{
        private String name;
        private float cgpa;
        private String enrollmentNo;
        private String password;

        public Student(String n,String pass,float cgpa,String no){
            this.name = n;
            this.enrollmentNo = no;
            this.cgpa = cgpa;
            this.password = pass;
        }

        private boolean checkCgpa(){
            if(this.cgpa<10.0 && this.cgpa>0.0)
                return true;
            return false;    
        }

        private boolean checkEnrollment(){
            String pattern = "^BE(20|21|22|23)(CSU|ENC|ECU|EEU)(0*(?:[1-9][0-9]?|1[0-9][0-9]|2[0-4][0-9]|250))$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(this.enrollmentNo);
            if(matcher.matches()){
                return true;
            }
            return false;
        }

        private boolean checkpassword() {
            int countUpper = 0, countLower = 0, countNum = 0, countSpecial = 0;
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (c >= 97 && c <123) {
                    countLower++;
                } else if (c >= 65 && c < 91) {
                    countUpper++;
                } else if (c == '$' || c == '!' || c == '%' || c == '&' || c =='@') {
                    countSpecial++;
                } else if (Character.isDigit(c)) {
                    countNum++;
                }

            }

            if (countUpper >= 1 && countLower >= 1 && countNum >= 1 && countSpecial >= 1 && password.length() >= 8) {
                System.out.println("Password is valid");
                return true;
            } else {
                try {
                    if(countLower<1){
                        throw new userException("No lowerCase letter");
                    }else if(countUpper<1){
                        throw new userException("No UpperCase letter");
                    }else if(countNum<1){
                        throw new userException("No Number");
                    }else if(password.length() < 8){
                        throw new userException("Length is less than 8");
                    }else if(countSpecial<1){
                        throw new userException("No Special Character");
                    }else{
                        throw new userException("Invalid Password.");
                    }
                } catch (userException e) {
                    System.out.println(e.getMessage());
                }
                return false;
            }
        }



        public void checker(){
            try{
                if(!checkEnrollment()){
                    throw new userException("Not a Valid Enrollment Number");
                }if(!checkpassword()){
                    return;
                }if(!checkCgpa()){
                    throw new userException("CGPA not valid");
                }
                else{
                    System.out.println("Everything is good");
                }
            }catch(userException e){
                System.out.println(e.getMessage());
            }
        }



    }

public class Practical5{
    public static void main(String args[]){
        Student s = new Student("Saurabh Wagh","Saurabh1234@", 9.5f,"BE20CSU240");
        s.checker();
        System.out.println();
        s = new Student("Ram","ram234@", 19.5f,"BE20CSU140");
        s.checker();
        System.out.println();
        s = new Student("Rashmi","Rashmi@", -10f,"BE24CSU244");
        s.checker();
        System.out.println();

    }
}
/******************************************************************************

                            VINAYAKA MUDRADI

*******************************************************************************/
class Parser{
    private int top;
    private char[] charArray;
    private char[] stack;
    Parser(){
        this.top = -1;
        System.out.println("Initialization Successful.!");
    }
    private char[] makeCharArray(String str){
        return str.toCharArray();
    }
    private char pop(){
        if(this.top!=-1){
            return this.stack[this.top--];
        }
        return 'n';
    }
    private void push(char c){
        this.top++;
        this.stack[this.top]=c;
    }
    public boolean parse(String str){
        boolean indicator=false;
        this.charArray = makeCharArray(str);
        this.stack = new char[this.charArray.length];
        for(int i=0; i<this.charArray.length; i++){
            if((int)this.charArray[i]==40 || (int)this.charArray[i]==91 || (int)this.charArray[i]==123){
                this.push(this.charArray[i]);
            }
            else if((int)this.charArray[i]==41 || (int)this.charArray[i]==93 || (int)this.charArray[i]==125){
                if(this.top==-1){
                    return false;
                }
                char temp = this.pop();
                if(((int)this.charArray[i]==41 && (int)temp==40) || ((int)this.charArray[i]==93 && (int)temp==91) || ((int)this.charArray[i]==125 && (int)temp==123)){
                    indicator=true;
                    continue;
                }
                else{
                    indicator=false;
                }
            }
        }
        if(this.top != -1){
            return false;
        }
        return indicator;
    }
    
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		String str = "{[(a+b)(a-b)][2+1*3]*a+(2*a)}";
		Parser p =new Parser();
		boolean isValid = p.parse(str);
		if(isValid){
		    System.out.println("This is balanced. :)");
		}
		else{
		    System.out.println("Sorry..! This is not balanced.");
		}
		
	}
}

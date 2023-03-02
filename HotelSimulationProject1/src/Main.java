
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    //final Room[] rooms = new Room[30];
    //final Staff[] staff = new Staff[50];
    static String[] CommandsArray ;
    public static void main(String[] args) {

        StringBuilder inputText = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("commands.txt"));
            String line = reader.readLine();
            while (line != null) {

                if (!line.equals("")) {
                    inputText.append(line).append("\n");
                }
                line = reader.readLine();
            }
            CommandsArray = inputText.toString().trim().split("\n");
            inputText = null;
            reader.close();
            //System.out.println(CommandsArray[1]);
        } catch (Exception e) {
            CommandsArray = null;
            System.out.println("Sorry, we were unable to access the text file.\nPlease check the name and location of your file and try again");
        }
      


        if( CommandsArray != null ) {

        	for(int i=0;i<20;i++) {
        		String[] command = CommandsArray[i].trim().split(";");
        		if(command[0].equals("addRoom")) {
        			Room room1 = new Room(Integer.parseInt(command[1]),command[2],Boolean.parseBoolean(command[3]),Boolean.parseBoolean(command[4]),Integer.parseInt(command[5]));
        			System.out.println(room1.getPrice()+" "+room1.getType());
        		}
        	}





        }










    }
}
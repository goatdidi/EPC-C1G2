import java.util.Scanner;

/***
 * @author goatdidi
 * Select（选择），Query（查询）, QueryAdjust（调节查询）, QueryRep（重复查询）, ACK（EPC答复）, NAK（转向裁断）, Req_RN（随机数请求），Read（读），Write（写），Kill（灭活），Lock（锁定）。
 **/
public class Reader {
    public static void main(String[] args) {
        String command;
        Tag tag = new Tag("Ready");
        while(true){
            System.out.println();
            System.out.println();
            System.out.println("1.发送命令");
            System.out.println("2.查询当前tag状态");
            System.out.println("3.退出");
            Scanner scan = new Scanner(System.in);
            String choose  = scan.nextLine();
            switch (choose){
                case "1":{
                    Scanner sc = new Scanner(System.in);
                    command = sc.nextLine();
                    if (command.equals("Select") || command.equals("Query") || command.equals("QueryAdjust") || command.equals("QueryRep") || command.equals("ACK") || command.equals("NAK") || command.equals("Req_RN") || command.equals("Read") || command.equals("Write") || command.equals("Kill") || command.equals("Lock") || command.equals("Access Password")){
                        tag.GetCommand(command);
                        tag.setCom(command);
                    }else {
                        System.out.println("啥命令啊 没这个命令");
                    }
                    break;
                }
                case "2":{
                    System.out.println("当前标签状态为 "+tag.getStatement());
                    break;
                }
                case "3":{
                    return;
                }
                default:break;

            }


        }



    }

}

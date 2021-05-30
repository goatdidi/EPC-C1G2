import java.util.Random;
import java.util.Scanner;

/***
 * @author goatdidi
 **/
public class Tag {
    private String statement;
    private String com;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
    public Tag() {

    }

    public Tag(String statement) {
        this.statement = statement;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "statement='" + statement + '\'' +
                ", com='" + com + '\'' +
                '}';
    }

    public void GetCommand(String command){
        System.out.println("密码缺省值为？");
        Scanner sc = new Scanner(System.in);
        String access_password=sc.nextLine();
        switch (command){
            case "Select" :{
                if (!getStatement().equals("Killed")){
                    setStatement("Ready");
                }else {
                    System.out.println("当前状态无法响应此命令");
                } break;
            }
            case "Query" : {
                if (getStatement().equals("Arbitrate")){
                    setStatement("Reply");
                }else if (getStatement().equals("Ready")){
                    Random rand = new Random();
                    if (rand.nextInt(3)==0){
                        setStatement("Reply");
                    }else setStatement("Arbitrate");
                } else{
                    System.out.println("当前状态无法响应此命令");
                }
                break;
            }
            case "ACK" :{
                if (getStatement().equals("Reply")){
                    System.out.println("EPC号码");
                    System.out.println("PC");
                    System.out.println("CRC");
                    setStatement("Acknowledged");
                }else if (getStatement().equals("Acknowledged")||getStatement().equals("Open")||getStatement().equals("Secured")){
                    System.out.println("EPC号码");
                    System.out.println("PC");
                    System.out.println("CRC");
                    System.out.println(" ");
                } else {
                    System.out.println("当前状态无法响应此命令");
                }
                break;
            }
            case "Req_RN":{

                    if (getStatement().equals("Acknowledged")){
                        if (access_password.equals("0")){
                            setStatement("Open");
                        }else System.out.println("access password不为0 无法进入open");
                    } else if (getStatement().equals("Open")||getStatement().equals("Secured")){
                        System.out.println(" ");;
                    } else{
                        System.out.println("当前状态无法响应此命令");
                    }
                    break;

            }
            case "Access Password":{
                    if (getStatement().equals("Open")){
                        if (!access_password.isEmpty()){
                            setStatement("Secured");
                        }else System.out.println("密码为空无法进入Secured状态");
                    }
                    break;
            }
            case "Read":{
                if (getStatement().equals("Open")||getStatement().equals("Secured")){
                    System.out.println(" ");
                }

            }
            case "Write":{
                if (getStatement().equals("Open")||getStatement().equals("Secured")){
                    System.out.println(" ");
                }
                break;

            }
            case "Kill":{
                if (getStatement().equals("Secured")){
                    System.out.println("提供密码");
                    Scanner scanner = new Scanner(System.in);
                    String pwd = scanner.nextLine();
                    if (pwd.equals(access_password)){
                        setStatement("Killed");
                    }
                }
                break;

            }
            case "Lock":{
                if (getStatement().equals("Open")||getStatement().equals("Secured")){
                    System.out.println(" ");
                }
                break;

            }
            case "QueryAdjust" :
            case "QueryRep": {
                if (getStatement().equals("Acknowledged")||getStatement().equals("Open")||getStatement().equals("Secured")){
                    setStatement("Ready");
                }
                break;

            }
            case "NAK":{
                System.out.println("不知道");
                break;
            }


        }

    }
    /*应该写成双线程的
    public void check(){
        int time = 100;
        if (getStatement().equals("Reply")||getStatement().equals("Acknowledged")){
            while (time>0){
                if (getCom().isEmpty()){
                    setStatement("Arbitrate");
                }
                time--;
            }
        }

    }*/

}


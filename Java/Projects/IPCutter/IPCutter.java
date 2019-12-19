package ipcutter;

class IPCutter{
  private char[] ip;
  private int lengthIP;

  public IPCutter(){
    lengthIP = 0;
    ip = new char[lengthIP];
  }

  public IPCutter(String IP){
    lengthIP = IP.length();
    ip = IP.toCharArray();
  }

  public String[] cutIP(){
    String[] ips = new String[4];
    for(int i=0; i<4; i++)
      ips[i] = "";
    int index = 0;
    for(int i=0; i<lengthIP; i++){
      if(ip[i] == '.'){
        index++;
        continue;
      }
      ips[index] += ip[i];
    }
    return ips;
  }


  public static void main(String[] args){
      IPCutter ipcutter = new IPCutter(args[0]);
      String[] IPS = new String[4];
      IPS = ipcutter.cutIP();
      for(int i=0; i<4; i++)
        System.out.println(IPS[i]);
    }
}

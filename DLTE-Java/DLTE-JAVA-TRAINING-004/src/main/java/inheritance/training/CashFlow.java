package inheritance.training;

public class CashFlow implements BasicProcedings {
    static Integer[] flow=new Integer[10];

    public static void main(String[] args) {
        CashFlow cashFlow=new CashFlow();
        cashFlow.insert(98);
       // cashFlow.list();

    }

    @Override
    public void insert(Object object) {
        for(int index=0;index<flow.length;index++){
            if(flow[index]==null){
                flow[index]=(Integer)object;
                System.out.println(object+ "inserted at "+index);
                return;
            }
        }
        System.out.println(object +"It doesnt have the space to occupy");
    }

    @Override
    public Object read(int position) {
        return null;
    }
}

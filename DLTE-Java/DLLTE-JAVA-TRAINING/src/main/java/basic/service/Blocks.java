package basic.service;
//scopes,overloading and execution points
class Blocks{
    static{
        System.out.println("casa,fund bond");
        Blocks.main(new Integer[]{12,24});
    }

    public static void main(Integer[] args) {
        System.out.println("check");
        System.out.println(args.length);
    }
    public static void main(String[] args) {
        System.out.println("CLI Banking");
        System.out.println();
    }


}


class Facility{
    public static void main(String[] args) {
        System.out.println("ATM, CDM,Passbook entry");
    }
}

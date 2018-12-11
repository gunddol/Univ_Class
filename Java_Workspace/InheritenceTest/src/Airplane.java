public class Airplane extends Vehicle{
    public Airplane(String _model, int _birth_year, String _type){
        super(_model, _birth_year, _type);
    }

    public void flight(){
        System.out.println(super.getModel() + "가 이륙하였습니다.");
    }
}

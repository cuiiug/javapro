package cn.hui.javapro.design.decorator;

public class TestM{


    public static void main(String[] args) {
        Project project = new Employer();
        ManagerA  ma = new ManagerA(project);
        ma.doCoding();
    }
}
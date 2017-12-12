package  cn.hui.javapro.design.decorator;


public class  ManagerA extends Manager{

    public ManagerA(Project project){
        super(project);
    }
    public void doEarlyWork(){
        System.out.println("项目经理在做前期工作。。。");
    }
	@Override
	public void doEndWork() {
		System.out.println("项目经理进行收尾工作....");
	}

}
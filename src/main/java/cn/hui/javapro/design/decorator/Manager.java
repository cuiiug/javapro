package cn.hui.javapro.design.decorator;

public abstract class Manager implements Project{

    private Project project;

    public Manager(Project project){
        this.project = project;
    }

	public void doCoding() {
		startWork();
	}

    public void startWork(){
        doEarlyWork();
        project.doCoding();
        doEndWork();
    }

    /**
     * 项目经理自己的事情，前期工作
     */
    public abstract void doEarlyWork();

    /**
     * 项目经理做收尾工作
     */
    public abstract void doEndWork();
}
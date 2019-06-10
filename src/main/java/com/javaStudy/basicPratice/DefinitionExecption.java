package com.javaStudy.basicPratice;

/**
 * @description 自定义异常
 * @date 2019/3/30
 */
public class DefinitionExecption extends  Exception{

    public DefinitionExecption() {
        super("发生异常拉");

    }

    public DefinitionExecption(String message) {
        super(message);
    }

    public DefinitionExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public DefinitionExecption(Throwable cause) {
        super(cause);
    }

    protected DefinitionExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}


class  DefinitionExecptionTest{

    public static void main(String[] args) {
try {
    test();
}
catch (Exception e){
    System.out.println(e.getMessage());
    e.printStackTrace();
}

    }
    private  static  void test() throws  DefinitionExecption{
        throw new DefinitionExecption();

    }

}


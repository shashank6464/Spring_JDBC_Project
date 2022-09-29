package com.springboot.jdbc.SpringBootJDBC.ErrorResponse;

public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException(){
        super();
    }

   // @Override
    public PlayerNotFoundException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(msg, cause, enableSuppression, writableStackTrace);
    }

    public PlayerNotFoundException(String msg, Throwable cause)
    {
        super(msg, cause);
    }

    public PlayerNotFoundException(String msg)
    {
        super(msg);
    }

    public PlayerNotFoundException(Throwable cause)
    {
        super(cause);
    }


}

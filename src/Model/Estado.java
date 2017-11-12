
package Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
    @JsonSubTypes.Type(value=Esperando.class, name="Esperando"),
    @JsonSubTypes.Type(value=Inicial.class, name="Inicial"),
    @JsonSubTypes.Type(value=Aceita.class, name="Aceita"),
    @JsonSubTypes.Type(value=Recusada.class, name="Recusada"),
    @JsonSubTypes.Type(value=Cancelada.class, name="Cancelada")
})  
public abstract class Estado {
    protected String status;
    protected String metodo;
    
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    public abstract String tratamento();
}

package implementacion;

public class FabricaServicios {
    
    // Tipos de proxy soportados
    public enum TipoProxy {
        CON_AUDITORIA,
        SIN_AUDITORIA
    }

    // Método de fábrica modificado
    public static InterfaceProcesos CrearEjecucionProceso(TipoProxy tipo) {
        switch (tipo) {
            case CON_AUDITORIA:
                return new ProxyProcesos(); // ya existente
            case SIN_AUDITORIA:
                return new ProxyAutenticacionSimple(); // nuevo proxy
            default:
                throw new IllegalArgumentException("Tipo de proxy no soportado");
        }
    }
}


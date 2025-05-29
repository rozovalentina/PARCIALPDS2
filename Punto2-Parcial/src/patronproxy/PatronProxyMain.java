package patronproxy;

import implementacion.InterfaceProcesos;
import implementacion.FabricaServicios;
import implementacion.FabricaServicios.TipoProxy;

public class PatronProxyMain {

    public static void main(String[] args) {
        String usuario = "fbolano";
        String password = "pds";
        int proceso = 1;
     // Cambiar entre CON_AUDITORIA y SIN_AUDITORIA
        InterfaceProcesos ProcesoActivo = FabricaServicios.CrearEjecucionProceso(TipoProxy.SIN_AUDITORIA);
        try {
            ProcesoActivo.EjecutarProcesos(proceso, usuario, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

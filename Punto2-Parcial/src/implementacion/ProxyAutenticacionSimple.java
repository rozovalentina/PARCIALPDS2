package implementacion;

import servicios.Seguridad;

/**
 * Proxy que solo realiza autenticación, sin auditoría.
 */
public class ProxyAutenticacionSimple implements InterfaceProcesos {

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {
        Seguridad securityService = new Seguridad();
        if (!securityService.Autorizacion(Usuario, Password)) {
            throw new Exception("El usuario '" + Usuario + "' no tiene privilegios para ejecutar el proceso.");
        }

        ProcesoDefecto ejecutor = new ProcesoDefecto();
        ejecutor.EjecutarProcesos(IdProceso, Usuario, Password);
    }
}

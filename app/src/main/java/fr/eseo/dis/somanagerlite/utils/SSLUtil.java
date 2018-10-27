package fr.eseo.dis.somanagerlite.utils;
import android.content.Context;
import android.util.Log;
import android.util.Pair;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import fr.eseo.dis.somanagerlite.R;

public class SSLUtil {

    private SSLSocketFactory sslSocketFactory;

    public SSLUtil(Context context, String certifactName){
        this.sslSocketFactory = getSocketFactory(context, certifactName);
    }

    private SSLSocketFactory getSocketFactory(Context currentContext, String certifactName) {

        CertificateFactory cf = null;
        try {
            Certificate ca = null;

            if(certifactName.equals("root")){
                ca = getCertificate(currentContext, R.raw.root);
            } else if (certifactName.equals("inter")) {
                ca = getCertificate(currentContext, R.raw.inter);
            } else if (certifactName.equals("chain")) {
                ca = getCertificate(currentContext, R.raw.chain);
            } else {
                Log.e("=========", "Non de certificat invalide !");
            }

            Log.e("CERT", "ca=" + ((X509Certificate) ca).getSubjectDN());

            String keyStoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);


            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(keyStore);


            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {

                    Log.e("CipherUsed", session.getCipherSuite());
                    return hostname.compareTo("192.168.4.248")==0; //The Hostname of your server

                }
            };


            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
            SSLContext context = null;
            context = SSLContext.getInstance("TLS");

            context.init(null, tmf.getTrustManagers(), null);
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

            SSLSocketFactory sf = context.getSocketFactory();


            return sf;

        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        return  null;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    private static Certificate getCertificate(Context context, int certId) throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        InputStream cert = context.getResources().openRawResource(certId);
        Certificate ca;
        try {
            ca = cf.generateCertificate(cert);
        } finally {
            try {
                cert.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ca;
    }
}
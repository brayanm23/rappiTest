package com.example.testrappi.api.services;

import com.activeandroid.Model;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class AbstractRestService<T> {
    private T service;
    private GsonConverterFactory converterFactory;

    /**
     * Constructor de la clase, se encarga de llamar a {@link #createGson()}
     */
    AbstractRestService() {
        createGson();
    }

    /**
     * Se encarga de crear un objeto {@link Gson} con la configuracion necesaria para el proyecto
     */
    private void createGson() {
        GsonBuilder gsonBuilder = createGsonBuilder();

        final Map<Type, Object> typeAdapters = getTypeAdapters();
        final Set<Type> types = typeAdapters.keySet();
        for (Type type : types) {
            gsonBuilder.registerTypeAdapter(type, typeAdapters.get(type));
        }

        converterFactory = GsonConverterFactory.create(gsonBuilder.create());
    }

    private GsonBuilder createGsonBuilder() {
        return new GsonBuilder()
                .addSerializationExclusionStrategy(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(Model.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .excludeFieldsWithoutExposeAnnotation()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    }

    /**
     * Crea una instancia del cliente Rest con todas las configuraciones asignadas
     *
     * @param restApiDefinitionInterface interface con la definicion de los servicios que a de aproveer la API Rest
     * @param endPoint                   URL del andpount base del cual salen los servicios que provee la API Rest
     * @param <T>                        El tipo de la interface que contiene los servicios que ha de proveer la API Rest
     * @return Instancia del cliente Rest
     */
    private <T> T createService(Class<T> restApiDefinitionInterface, String endPoint/*, Interceptor interceptor*/) {
        final Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                //.client(getOkHttpClient(interceptor))
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return mRetrofit.create(restApiDefinitionInterface);
    }

    /**
     * @return Configura y devuelve un objeto {@link okhttp3.OkHttpClient} configurado
     */
    /*private okhttp3.OkHttpClient getOkHttpClient(Interceptor interceptor) {
        final okhttp3.OkHttpClient.Builder client = new okhttp3.OkHttpClient().newBuilder();
        client.connectTimeout(1200, TimeUnit.SECONDS);
        client.readTimeout(1200, TimeUnit.SECONDS);
        client.writeTimeout(1200, TimeUnit.SECONDS);
        client.addInterceptor(interceptor);

        client.addInterceptor(new ProvideCacheInterceptor());
        client.addInterceptor(new ProvideOfflineCacheInterceptor());
        client.cache(provideCache());

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            // development build
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            // production build
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        client.addInterceptor(logging);
        return client.build();
    }*/

    /*private static Cache provideCache ()
    {
        Cache cache = null;
        try
        {
            cache = new Cache( new File( Application.get().getCacheDir(), "http-cache" ),
                    10 * 1024 * 1024 ); // 10 MB
        }
        catch (Exception e)
        {
            Timber.e( e, "Could not create Cache!" );
        }
        return cache;
    }*/

    /**
     * Crea y retorna una instancia del servicio cliente definido por que devuelve {@link #getRestApiDefinitionInterface()}
     *
     * @return na instancia del servicio cliente
     */
    public T getService() {
        if (service == null)
            service = createService(getRestApiDefinitionInterface(), getServiceEndPoint()/*, getRequestInterceptor()*/);
        return service;
    }

    /**
     * Crea y retorna una instancia del servicio cliente definido por que devuelve {@link #getRestApiDefinitionInterface()}
     *
     * @return na instancia del servicio cliente
     */
    public T getService(Interceptor interceptor) {
        if (service == null)
            service = createService(getRestApiDefinitionInterface(), getServiceEndPoint()/*, interceptor*/);
        return service;
    }

    /**
     * Permite definir y devolver un {@link Interceptor} para cosas como agregar parametros al Header de una consulta a la API.
     * Es utilizado para crear la instancia del servicio cliente. Por defecto devuelve una instancia de {@link SessionRequestInterceptor}.
     *
     * @return instancia de {@link Interceptor}
     */
    /*protected Interceptor getRequestInterceptor() {
        return new SessionRequestInterceptor();
    }*/

    /**
     * Permite definir y devolver un {@link Map} de [{@link Type}, {@link com.google.gson.TypeAdapter}]  para configurar el servicio cliente.
     * Por default es un mapa vacio.
     *
     * @return Mapa con los {@link com.google.gson.TypeAdapter}
     */
    protected Map<Type, Object> getTypeAdapters() {
        return new HashMap<>();
    }

    /**
     * @return Objeto {@link Class} de la interface que contiene la definicion de los servicios que ha de proveer la API Rest.
     * Es necesaria para crear una instancia del servicio rest que dicha interface representa
     */
    protected abstract Class<T> getRestApiDefinitionInterface();

    /**
     * @return String con el endpoint donde se encuentra el servicio Rest en el servidor
     */
    protected abstract String getServiceEndPoint();
}

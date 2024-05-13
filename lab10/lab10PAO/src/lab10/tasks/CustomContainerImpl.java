package lab10.tasks;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CustomContainerImpl implements CustomContainer {
    private final Map<String, Object> instances = new HashMap<>();
    private final Map<Class<?>, Function<CustomContainer, ?>> factories = new HashMap<>();

    @Override
    public <T> boolean addInstance(T instance) {
        if (instance == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }
        String dependencyName = instance.getClass().getName();
        return addInstance(instance, dependencyName);
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) {
        if (instance == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }
        if (customName == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        if (instances.containsKey(customName)) {
            throw new CustomContainerException("Instances cannot be redeclared");
        }
        instances.put(customName, instance);
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        if (type == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        String typeName = type.getName();
        return getInstance(type, typeName);
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if (type == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }
        if (customName == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        if(instances.containsKey(customName)){
            Object instance = instances.get(customName);
            if(!type.isInstance(instance)){
                throw new CustomContainerException("Invalid type for object");
            }
            return type.cast(instance);
        }

        if(factories.containsKey(type)){
            T instance = create(type);
            addInstance(instance, customName);
            return instance;
        }

        throw new CustomContainerException("Cannot provide instance");
    }

    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) {
        if (type == null || factoryMethod == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        factories.put(type, factoryMethod);
        return true;
    }

    @Override
    public <T> T create(Class<T> type) {
        if (type == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }
        Function<CustomContainer, ?> factory = factories.get(type);
        if (factory == null) {
            throw new CustomContainerException("Cannot provide instance");
        }
        return type.cast(factory.apply(this));
    }

    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if (type == null || parameters == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        Function<CustomContainer, ?> factory = factories.get(type);
        if (factory == null) {
            throw new CustomContainerException("Cannot provide instance");
        }

        try {
            Object rawInstance = factory.apply(this);
            T instance = type.cast(rawInstance);
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                Field field = instance.getClass().getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            }
            return instance;
        } catch (Exception e) {
            throw new CustomContainerException(e.toString());
        }
    }

    @Override
    public void close() throws Exception {
        for (Object instance : instances.values()) {
            if (instance instanceof AutoCloseable) {
                ((AutoCloseable) instance).close();
            }
        }
    }
}
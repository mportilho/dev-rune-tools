package io.github.mportilho.sentencecompiler.syntaxtree.function;

public class FunctionMetadataUtils {

    public static LambdaCallerInterface createLambdaCaller(Object lambda, Object instance, Class<?>[] parameterTypes) {
        if (lambda instanceof LambdaFunctionInterfacesWrapper.Function1 f) {
            return (s, p) -> f.apply(instance);
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function2 f) {
            return (s, p) -> f.apply(instance,
                    s.convert(p[0], parameterTypes[0], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function3 f) {
            return (s, p) -> f.apply(instance,
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function4 f) {
            return (s, p) -> f.apply(instance,
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function5 f) {
            return (s, p) -> f.apply(instance,
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null),
                    s.convert(p[3], parameterTypes[3], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function6 f) {
            return (s, p) -> f.apply(instance,
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null),
                    s.convert(p[3], parameterTypes[3], null),
                    s.convert(p[4], parameterTypes[4], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function7 f) {
            return (s, p) -> f.apply(instance,
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null),
                    s.convert(p[3], parameterTypes[3], null),
                    s.convert(p[4], parameterTypes[4], null),
                    s.convert(p[5], parameterTypes[5], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function8 f) {
            return (s, p) -> f.apply(instance,
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null),
                    s.convert(p[3], parameterTypes[3], null),
                    s.convert(p[4], parameterTypes[4], null),
                    s.convert(p[5], parameterTypes[5], null),
                    s.convert(p[6], parameterTypes[6], null));
        }
        throw new IllegalArgumentException(String.format("Class [%s] not illegible as lambda caller", lambda.getClass().getName()));
    }

    public static LambdaCallerInterface createStaticLambdaCaller(Object lambda, Class<?>[] parameterTypes) {
        if (lambda instanceof LambdaFunctionInterfacesWrapper.Function1 f) {
            return (s, p) -> f.apply(
                    s.convert(p[0], parameterTypes[0], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function2 f) {
            return (s, p) -> f.apply(
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[0], parameterTypes[1], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function3 f) {
            return (s, p) -> f.apply(
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[0], parameterTypes[2], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function4 f) {
            return (s, p) -> f.apply(
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null),
                    s.convert(p[0], parameterTypes[3], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function5 f) {
            return (s, p) -> f.apply(
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null),
                    s.convert(p[3], parameterTypes[3], null),
                    s.convert(p[0], parameterTypes[4], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function6 f) {
            return (s, p) -> f.apply(
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null),
                    s.convert(p[3], parameterTypes[3], null),
                    s.convert(p[4], parameterTypes[4], null),
                    s.convert(p[0], parameterTypes[5], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function7 f) {
            return (s, p) -> f.apply(
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null),
                    s.convert(p[3], parameterTypes[3], null),
                    s.convert(p[4], parameterTypes[4], null),
                    s.convert(p[5], parameterTypes[5], null),
                    s.convert(p[0], parameterTypes[6], null));
        } else if (lambda instanceof LambdaFunctionInterfacesWrapper.Function8 f) {
            return (s, p) -> f.apply(
                    s.convert(p[0], parameterTypes[0], null),
                    s.convert(p[1], parameterTypes[1], null),
                    s.convert(p[2], parameterTypes[2], null),
                    s.convert(p[3], parameterTypes[3], null),
                    s.convert(p[4], parameterTypes[4], null),
                    s.convert(p[5], parameterTypes[5], null),
                    s.convert(p[6], parameterTypes[6], null),
                    s.convert(p[0], parameterTypes[7], null));
        }
        throw new IllegalArgumentException(String.format("Class [%s] not illegible as lambda caller", lambda.getClass().getName()));
    }

}

package org.todeschini;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuilderMaster {
    Set<String> listaImports;

    public BuilderMaster() {
        this.listaImports = new HashSet<>();
        this.listaImports.add("import java.util.Arrays;");
    }

    public void gerarCodigoClasse(Class classe) {
        String nomeClasse = String.valueOf(classe.getSimpleName()) + "Builder";
        StringBuilder builder = new StringBuilder();
        builder.append("public class ").append(nomeClasse).append(" {\n");
        builder.append("\tprivate ").append(classe.getSimpleName()).append(" element;\n");
        builder.append("\tprivate ").append(nomeClasse).append("(){}\n\n");
        builder.append("\tpublic static ").append(nomeClasse).append(" Builder").append(classe.getSimpleName()).append("() {\n");
        builder.append("\t\t").append(nomeClasse).append(" builder = new ").append(nomeClasse).append("();\n");
        builder.append("\t\tinitObject(builder);\n");
        builder.append("\t\treturn builder;\n");
        builder.append("\t}\n\n");
        builder.append("\tpublic static void initObject(").append(nomeClasse).append(" builder) {\n");
        builder.append("\t\tbuilder.element = new ").append(classe.getSimpleName()).append("();\n");
        builder.append("\t\t").append(classe.getSimpleName()).append(" element = builder.element;\n");
        builder.append("\n\t\t\n");
        List<Field> declaredFields = getClassFields(classe);
        for (Field campo : declaredFields) {
            if (campo.getName().equals("serialVersionUID"))
                continue;
            if (Modifier.isStatic(campo.getModifiers()))
                continue;
            builder.append("\t\telement.set").append(campo.getName().substring(0, 1).toUpperCase()).append(campo.getName().substring(1)).append("(").append(getDefaultParameter(campo)).append(");\n");
        }
        builder.append("\t}\n\n");
        for (Field campo : declaredFields) {
            if (campo.getName().equals("serialVersionUID"))
                continue;
            if (Modifier.isStatic(campo.getModifiers()))
                continue;
            if (campo.getType().getSimpleName().equals("List")) {
                ParameterizedType stringListType = (ParameterizedType)campo.getGenericType();
                builder.append("\tpublic ")
                        .append(nomeClasse)
                        .append(" comLista").append(campo.getName().substring(0, 1).toUpperCase()).append(campo.getName().substring(1))
                        .append("(").append(((Class)stringListType.getActualTypeArguments()[0]).getSimpleName()).append("... params) {\n");
                builder.append("\t\telement.set").append(campo.getName().substring(0, 1).toUpperCase()).append(campo.getName().substring(1)).append("(Arrays.asList(params));\n");
                builder.append("\t\treturn this;\n");
                builder.append("\t}\n\n");
                continue;
            }
            builder.append("\tpublic ")
                    .append(nomeClasse)
//        .append(" com").append(campo.getName().substring(0, 1).toUpperCase()).append(campo.getName().substring(1))
                    .append(" ").append(campo.getName())//.substring(0, 1).toUpperCase()).append(campo.getName().substring(1))
                    .append("(").append(campo.getType().getSimpleName()).append(" param) {\n");
            registrarImports(campo.getType().getCanonicalName());
            builder.append("\t\telement.set")
                    .append(campo.getName().substring(0, 1).toUpperCase()).append(campo.getName().substring(1))
                    .append("(param);\n");
            builder.append("\t\treturn this;\n");
            builder.append("\t}\n\n");
        }
        builder.append("\tpublic ").append(classe.getSimpleName()).append(" build() {\n");
        //builder.append("\tpublic ").append(classe.getSimpleName()).append(" agora() {\n");
        builder.append("\t\treturn element;\n");
        builder.append("\t}\n");
        builder.append("}");
        for (String str : this.listaImports)
            System.out.println(str);
        System.out.println("import " + classe.getCanonicalName() + ";");
        System.out.println("\n");
        System.out.println(builder.toString());
    }

    public List<Field> getClassFields(Class classe) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(classe.getDeclaredFields()));
        Class<Object> superClass = classe.getSuperclass();
        if (superClass != Object.class) {
            List<Field> fieldsSC = Arrays.asList(superClass.getDeclaredFields());
            fields.addAll(fieldsSC);
        }
        return fields;
    }

    public String getDefaultParameter(Field campo) {
        String tipo = campo.getType().getSimpleName();
        if (tipo.equals("int") || tipo.equals("Integer"))
            return "0";
        if (tipo.equals("long") || tipo.equals("Long"))
            return "0L";
        if (tipo.equals("double") || tipo.equals("Double"))
            return "0.0";
        if (tipo.equals("boolean") || tipo.equals("Boolean"))
            return "false";
        if (tipo.equals("String"))
            return "\"\"";
        return "null";
    }

    public void registrarImports(String classe) {
        if (classe.contains("."))
            this.listaImports.add("import " + classe + ";");
    }
}



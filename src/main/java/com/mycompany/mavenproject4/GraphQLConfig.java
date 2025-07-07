package com.mycompany.mavenproject4;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Objects;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

public class GraphQLConfig {
    public static GraphQL init() throws IOException {
        InputStream schemaStream = GraphQLConfig.class.getClassLoader().getResourceAsStream("schema.graphqls");

        if (schemaStream == null) {
            throw new RuntimeException("schema.graphqls not found in classpath.");
        }

        String schema = new String(Objects.requireNonNull(schemaStream).readAllBytes());
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schema);
        RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
        .type("Query", builder -> builder
            .dataFetcher("allVisits", env -> VisitLogRepo.findAll())
            .dataFetcher("visitById", env -> {
                int id = env.getArgument("id");
                return VisitLogRepo.findById(id);
            })
        )
        .type("Mutation", builder -> builder
            .dataFetcher("addVisit", env -> VisitLogRepo.add(
                env.getArgument("studentId"),
                env.getArgument("studentName"),
                env.getArgument("studentProgram"),
                env.getArgument("purpose"),
                ((LocalDateTime) env.getArgument("visitTime")).now()
            ))
        )
        .build();
        GraphQLSchema schemaFinal = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        return GraphQL.newGraphQL(schemaFinal).build();
    }
}

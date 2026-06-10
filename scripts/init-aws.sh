#!/bin/bash
# Script de inicialização do LocalStack
# Executado automaticamente quando o container sobe
# Documentação: https://docs.localstack.cloud/references/init-hooks/

set -euo pipefail

AWS="aws --endpoint-url=http://localhost:4566 --region=sa-east-1"

echo "===== Inicializando recursos no LocalStack ====="

# ──────────────────────────────────────────────
# SQS - Filas de mensagens
# ──────────────────────────────────────────────
# echo "Criando filas SQS..."
# $AWS sqs create-queue --queue-name email-cadastro-usuario
# $AWS sqs create-queue --queue-name email-cadastro-tarefas
# $AWS sqs create-queue --queue-name user-registration-queue

# ──────────────────────────────────────────────
# SNS - Tópicos de notificação
# ──────────────────────────────────────────────
# echo "Criando tópicos SNS..."
# $AWS sns create-topic --name task-notifications
# $AWS sns create-topic --name user-notifications

# ──────────────────────────────────────────────
# SES - Serviço de email
# ──────────────────────────────────────────────
# echo "Verificando identidades de email no SES..."
# $AWS ses verify-email-identity --email-address lucast.leopoldino.rodrigues@gmail.com

# ──────────────────────────────────────────────
# S3 - Buckets de armazenamento
# ──────────────────────────────────────────────
# echo "Criando buckets S3..."
# $AWS s3 mb s3://anexos-tarefas
# $AWS s3 mb s3://backups-aplicacao

# ──────────────────────────────────────────────
# DynamoDB - Tabelas NoSQL
# ──────────────────────────────────────────────
# echo "Criando tabelas DynamoDB..."
# $AWS dynamodb create-table \
#     --table-name tarefas \
#     --attribute-definitions AttributeName=id,AttributeType=S \
#     --key-schema AttributeName=id,KeyType=HASH \
#     --billing-mode PAY_PER_REQUEST

# ──────────────────────────────────────────────
# SSM - Parâmetros
# ──────────────────────────────────────────────
# echo "Criando parâmetros no SSM..."
# $AWS ssm put-parameter --name /app/jwt-secret --value "minha-chave-local" --type SecureString
# $AWS ssm put-parameter --name /app/db-password --value "admin123" --type SecureString

echo "===== LocalStack inicializado com sucesso ====="
echo "AWS endpoint: http://localhost:4566"
echo "Região: sa-east-1"
echo ""
echo "Comandos úteis:"
echo "  aws --endpoint-url=http://localhost:4566 s3 ls"
echo "  aws --endpoint-url=http://localhost:4566 sqs list-queues"
echo "  aws --endpoint-url=http://localhost:4566 ses list-identities"
echo "  aws --endpoint-url=http://localhost:4566 dynamodb list-tables"

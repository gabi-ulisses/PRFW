#!/bin/bash

# Este script inicia o serviço do MySQL e restaura o banco de dados do projeto.


mysql_ping() {
        mysql --protocol=tcp --port=3307 --user=root --password=root -e "SELECT 1" &> /dev/null
}

mysql_start() {
        if [ "$USER" = "aluno" ]; then
	    sudo /bin/systemctl start mysql.service
        else
            podman start lojadb
        fi
}



# Iniciando o serviço do MySQL
if ! mysql_ping; then
    echo -n "Starting MySQL..."
    mysql_start

    # Waiting MySQL to start
    while ! mysql_ping; do
        echo -n "."
        sleep 0.1
    done
    echo "Done!"
else
    echo "MySQL is running."
fi


# Criando o banco de dados
echo "Creating database schema..."
mysql --protocol=tcp --port=3307 --user=root --password=root < database.sql



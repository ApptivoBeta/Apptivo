using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Apptivo.Models;
using System.Data;
using System.Data.OleDb;
using System.Web.Mvc;
using System.ComponentModel.DataAnnotations;

namespace Apptivo.Models
{
    public class Usuario
    {
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Email { get; set;  }
        public string Contraseña { get; set; }
        public string Sexo { get; set; }

        private string NombreArchivo = "Apptivo.mdb";
        private OleDbConnection nCon;
        private void Conectar()
        {
            string proovedor = @"Provider=Microsoft.Jet.OLEDB.4.0;  Data Source = |DataDirectory|" + NombreArchivo;
            nCon = new OleDbConnection();
            nCon.ConnectionString = proovedor;
            nCon.Open();
        }
        public void AgregarUsuario()
        {
            Conectar();
            OleDbCommand Consulta = nCon.CreateCommand();
            Consulta.CommandType = CommandType.StoredProcedure;
            Consulta.CommandText = "AgregarUsuario";
            OleDbParameter ParNombre = new OleDbParameter("ParNombre", Nombre);
            Consulta.Parameters.Add(ParNombre);
            OleDbParameter ParApellido = new OleDbParameter("ParApellido", Apellido);
            Consulta.Parameters.Add(ParApellido);
            OleDbParameter ParEmail = new OleDbParameter("ParEmail", Email);
            Consulta.Parameters.Add(ParEmail);
            OleDbParameter ParContraseña = new OleDbParameter("ParContraseña", Contraseña);
            Consulta.Parameters.Add(ParContraseña);
            OleDbParameter ParSexo = new OleDbParameter("ParSexo", Sexo);
            Consulta.Parameters.Add(ParSexo);
            Consulta.ExecuteNonQuery();
            nCon.Close();
        }
    }
}
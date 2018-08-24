using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace LojaWeb.Models {
    public class Produto {
        public int Id { get; set; }
        [Required, StringLength(100)]
        public string Descricao { get; set; }
        [Required, StringLength(20)]
        public string Nome { get; set; }
        public float Preco { get; set; }
        public int Quantidade { get; set; }
        public CategoriaProduto Categoria { get; set; }
        public int CategoriaID { get; set; }
    }
}
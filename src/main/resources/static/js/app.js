// app.js - consumo simples da API de livros

const API_BASE = '/livro';

async function listBooks() {
  const res = await fetch(`${API_BASE}/listar`);
  if (!res.ok) throw new Error('Erro ao listar livros');
  return res.json();
}

async function getBook(id) {
  const res = await fetch(`${API_BASE}/${id}`);
  if (!res.ok) throw new Error('Livro não encontrado');
  return res.json();
}

async function createBook(book) {
  const res = await fetch(`${API_BASE}/cadastrar`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(book)
  });
  if (!res.ok) throw new Error('Erro ao criar livro');
  return res.json();
}

async function createBooksBatch(books) {
  const res = await fetch(`${API_BASE}/cadastrar/lote`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(books)
  });
  if (!res.ok) throw new Error('Erro ao cadastrar lote');
  return res.json();
}

async function updateBook(id, book) {
  const res = await fetch(`${API_BASE}/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(book)
  });
  if (!res.ok) throw new Error('Erro ao atualizar livro');
  return res.json();
}

async function deleteBook(id) {
  const res = await fetch(`${API_BASE}/${id}`, { method: 'DELETE' });
  if (res.status === 204) return true;
  throw new Error('Erro ao deletar livro');
}

// Exemplo de uso: preencher uma lista no DOM
async function renderBookList(containerId) {
  try {
    const livros = await listBooks();
    const container = document.getElementById(containerId);
    container.innerHTML = '';
    livros.forEach(l => {
      const el = document.createElement('div');
      el.className = 'book-item';
      el.innerHTML = `<strong>${escapeHtml(l.titulo || '')}</strong> — ${escapeHtml(l.autor || '')}`;
      container.appendChild(el);
    });
  } catch (err) {
    console.error(err);
  }
}

function escapeHtml(str) {
  return str.replace(/[&<>"]/g, function(m) { return ({ '&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;' })[m]; });
}

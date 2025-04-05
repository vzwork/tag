// /pages/api/sign-in.js
export default async function handler(req, res) {
    const result = await fetch(process.env.NEXT_PUBLIC_API + '/signIn', {
        method: req.method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(req.body),
    });

    const data = await result.json();
    res.status(result.status).json(data);
}

"use client";

import { createContext, useContext, useState, useEffect, ReactNode } from 'react';


type User = {
    id: string;
    email: string;
    nameFirst: string;
    nameLast: string;
};

type AuthContextType = {
    user: User | null;
    signIn: (email: string, password: string) => Promise<void>;
    signUp: (email: string, password: string, firstName: string, lastName: string) => Promise<void>;
    signOut: () => void;
    updateUser: (user: User) => Promise<void>;
    loading: boolean;
};

const AuthContext = createContext<AuthContextType | null>(null);

export function AuthProvider({ children }: { children: ReactNode }) {
    const [user, setUser] = useState<User | null>(null);
    const [loading, setLoading] = useState(true);

    // useEffect(() => {
    //     const storedUser = localStorage.getItem('user');
    //     if (storedUser) {
    //         setUser(JSON.parse(storedUser));
    //     }
    //     setLoading(false);
    // }, []);

    const signIn = async (email: string, password: string) => {

        const res = await fetch('/api/signIn', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password }),
        })

        const data = await res.json();
        console.log(data);
        setUser(data.data.content);
    };

    const signUp = async (email: string, password: string, nameFirst: string, nameLast: string) => {
        const res = await fetch('/api/signUp', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password, nameFirst, nameLast }),
        })
        const data = await res.json();
        console.log(data);
        setUser(data.data.content);

    }

    const updateUser = async (user: User) => {
        console.log(user);

        const res = await fetch('/api/updateUser', {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(user),
        })
        const data = await res.json();
        setUser(data.data.content);
    }


    const signOut = () => {
        setUser(null);
        localStorage.removeItem('user');
    };

    return (
        <AuthContext.Provider value={{ user, signIn, signUp, signOut, updateUser, loading }}>
            {children}
        </AuthContext.Provider>
    );
}

export function useAuth() {
    const context = useContext(AuthContext);
    if (!context) throw new Error('useAuth must be used within AuthProvider');
    return context;
}

"use client";

import Container from "@/app/_components/container";
import Navbar from "../_components/navbar";
import { useAuth } from "@/context/AuthContext";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";

export default function Auth() {
    const router = useRouter();


    const { signIn, signUp, user, signOut } = useAuth();
    const [signInMenu, setSignInMenu] = useState(true);

    useEffect(() => {
        console.log(user);
        if (user?.nameFirst || user?.nameLast) {
            router.push('/dashboard');
        }
    });

    return (
        <main>
            <Container>
                <Navbar />
                <div className="container mx-auto">
                    <div className="flex flex-col items-center justify-center min-h-screen p-4">
                        <h1 className="text-4xl font-bold">Welcome!</h1>
                        <div className="flex gap-4 mt-4">
                            <button className="btn btn-lg" onClick={() => setSignInMenu(true)}>Sign In</button>
                            <button className="btn btn-lg" onClick={() => setSignInMenu(false)}>Sign Up</button>
                        </div>
                        <div className="mt-4 width-full max-w-md">

                            {signInMenu ? (
                                <div>
                                    {/* <h2 className="text-2xl font-bold">Login</h2> */}
                                    <form onSubmit={(e) => {
                                        e.preventDefault();
                                        const formData = new FormData(e.target as HTMLFormElement);
                                        const email = formData.get('email') as string;
                                        const password = formData.get('password') as string;
                                        signIn(email, password);
                                    }}>
                                        <fieldset className="fieldset">
                                            <input type="email" name="email" placeholder="Email" required className="input" />
                                            <input type="password" name="password" placeholder="Password" required className="input" />
                                        </fieldset>
                                        <button type="submit" className="btn btn-wide btn-accent">Submit</button>
                                    </form>
                                </div>
                            ) : (
                                <div>
                                    {/* <h2 className="text-2xl font-bold">Login</h2> */}
                                    <form onSubmit={(e) => {
                                        e.preventDefault();
                                        const formData = new FormData(e.target as HTMLFormElement);
                                        const email = formData.get('email') as string;
                                        const password = formData.get('password') as string;
                                        const firstName = formData.get('firstName') as string;
                                        const lastName = formData.get('lastName') as string;
                                        signUp(email, password, firstName, lastName);
                                    }}>
                                        <fieldset className="fieldset">
                                            <input type="text" name="firstName" placeholder="First Name" required className="input" />
                                            <input type="text" name="lastName" placeholder="Last Name" required className="input" />
                                            <input type="email" name="email" placeholder="Email" required className="input" />
                                            <input type="password" name="password" placeholder="Password" required className="input" />
                                        </fieldset>

                                        <button type="submit" className="btn btn-wide btn-accent">Submit</button>
                                    </form>
                                </div>
                            )}
                        </div>
                    </div>
                </div>
            </Container>
        </main>
    )
}
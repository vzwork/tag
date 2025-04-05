"use client";

import Container from "@/app/_components/container";
import Navbar from "../_components/navbar";
import { useAuth } from "@/context/AuthContext";

export default function Dashboard() {
    const { signIn, user, signOut, updateUser } = useAuth();

    return (
        <main>
            <Container>
                <Navbar />
                {user ? (


                    <div className="flex flex-col items-center justify-center min-h-screen p-4">
                        <h1 className="text-4xl font-bold">Welcome, {user.nameFirst} {user.nameLast}!</h1>
                        <form onSubmit={(e) => {
                            e.preventDefault();
                            const formData = new FormData(e.target as HTMLFormElement);
                            const nameFirst = formData.get('nameFirst') as string;
                            const nameLast = formData.get('nameLast') as string;
                            updateUser({
                                ...user,
                                nameFirst,
                                nameLast,
                            });
                        }}>

                            <fieldset className="fieldset">
                                <legend className="fieldset-legend">Update first name</legend>
                                <input type="text" className="input" name='nameFirst' placeholder={user.nameFirst} />

                            </fieldset>
                            <fieldset className="fieldset">
                                <legend className="fieldset-legend">Update last name.</legend>
                                <input type="text" className="input" name='nameLast' placeholder={user.nameLast} />

                            </fieldset>
                            <button type="submit" className="btn btn-wide btn-accent">save</button>
                        </form>
                        <button className="btn btn-lg" onClick={() => signOut()}>sign out</button>
                    </div>
                )
                    : (
                        <div className="flex flex-col items-center justify-center min-h-screen p-4">
                            <h1 className="text-4xl font-bold">Please sign in to access the dashboard.</h1>
                        </div>
                    )
                }

            </Container>
        </main>
    );
}
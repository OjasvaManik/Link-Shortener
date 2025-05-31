'use client'

import { Button } from "@/components/ui/button"
import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
} from "@/components/ui/card"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import React, { useState } from "react";


const Main = () => {
    const [url, setUrl] = useState('')
    const [shortUrl, setShortUrl] = useState('')

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault()
        if (!url) {
            alert('Please enter a URL')
            return
        }
        const res = await fetch('http://100.81.212.125:8080/api/shorturl', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ longUrl: url })
        })

        const data = await res.json()
        setShortUrl(data.shortUrl)
    }

    return (
        <Card className="w-full max-w-sm bg-black border-none drop-shadow-lg drop-shadow-white text-amber-600 font-mono">
            <CardHeader>
                <CardTitle>Create Short URL</CardTitle>
                <CardDescription className="text-amber-300">
                    Enter your url below to create a short link.
                </CardDescription>
            </CardHeader>
            <CardContent>
                <form onSubmit={handleSubmit}>
                    <div className="flex flex-col gap-6">
                        <div className="grid gap-2">
                            <Label htmlFor="url">URL</Label>
                            <Input
                                id="url"
                                type="text"
                                placeholder="example.com"
                                required
                                autoComplete="off"
                                onChange={(e) => setUrl(e.target.value)}
                                className="focus-visible:ring-amber-300 border-none"
                            />
                        </div>
                        <div className="grid gap-2">
                            <Label htmlFor="shortUrl">Short URL</Label>
                            {shortUrl && (
                                <a href={shortUrl} target="_blank" rel="noopener noreferrer" className="text-amber-300 overflow-hidden">
                                    {shortUrl}
                                </a>
                            )}
                        </div>
                    </div>
                    <CardFooter className="flex-col gap-2 pt-4">
                        <Button type="submit" className="w-full">
                            GENERATE
                        </Button>
                    </CardFooter>
                </form>
            </CardContent>
        </Card>
    )
}

export default Main

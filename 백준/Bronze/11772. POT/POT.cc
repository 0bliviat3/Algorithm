#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

long long pot(int p) {
	long long a = p / 10;
	long long b = p % 10;
	return pow(a, b);
}

void solve() {
	int n;
	std::cin >> n;
	long long sum = 0LL;
	while (n--) {
		int p;
		std::cin >> p;
		sum += pot(p);
	}
	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}